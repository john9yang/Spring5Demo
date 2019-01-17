package service.ipml;

import entity.ResultModel;
import entity.ResultViewModel;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class ReactiveServiceImpl {

    //mock data
    private static List<ResultModel> resultModelList = new ArrayList<>();

    static {
        ResultModel model = new ResultModel();
        model.setId(1);
        model.setContent("This is first model");
        resultModelList.add(model);

        model = new ResultModel();
        model.setId(2);
        model.setContent("This is second model");
        resultModelList.add(model);
    }

    /**
     * get the result by the pathVar {"id"}
     * @param serverRequest the request
     * @return the result model
     */
    public Mono<ResultViewModel> extraResult(ServerRequest serverRequest){
         int id = Integer.parseInt(serverRequest.pathVariable("id"));
         ResultModel model = null;
         ResultViewModel resultViewModel;

         for( ResultModel m : resultModelList ){
             if ( m.getId() == id ){
                 model = m;
                 break;
             }
         }

         if ( model != null ){
             resultViewModel = new ResultViewModel(200,"ok",model);
         }
         else{
             resultViewModel = ResultViewModel.EMPTY_RESULT;
         }

         //return the result
        return Mono.just(resultViewModel);
    }

    /**
     * return total result view
     * @param serverRequest the request
     * @return flux of total result model view
     */
    public Flux<ResultViewModel> flowAllResult(ServerRequest serverRequest) {
        List<ResultViewModel> result = new ArrayList<>();
        for (ResultModel model : resultModelList) {
            result.add(new ResultViewModel(200, "ok", model));
        }

        return Flux.fromIterable(result);
    }

    /**
     * the "write" api
     * @param serverRequest the request
     * @return the write object
     */
    public Mono<ResultViewModel> putItem(ServerRequest serverRequest) {
        //get the object and put to list
        Mono<ResultModel> model = serverRequest.bodyToMono(ResultModel.class);
        final ResultModel[] data = new ResultModel[1];

        model.doOnNext(new Consumer<ResultModel>() {
            @Override
            public void accept(ResultModel model) {
                //check if we can put this data
                boolean check = true;
                for (ResultModel r : resultModelList) {
                    if (r.getId() == model.getId()) {
                        check= false;
                        break;
                    }
                }

                if (check) {
                    data[0] = model;
                    //put it!
                    resultModelList.add(model);
                    System.out.printf("resultModelList size:"+resultModelList.size());
                } else {
                    data[0] = null; //error
                }
            }
        });

        ResultViewModel resultViewModel;
//        if (data[0] == null) { //error
//            resultViewModel = new ResultViewModel(200, "ok", data[0]);
//        } else { //success
//            resultViewModel = ResultViewModel.EMPTY_RESULT;
//        }

        resultViewModel = new ResultViewModel(200, "ok", data[0]);

        //return the result
        return Mono.just(resultViewModel);
    }


}