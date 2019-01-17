package handler;

import entity.ResultViewModel;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.ipml.ReactiveServiceImpl;

import java.util.function.Function;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class ReactiveHandler {

    private ReactiveServiceImpl resultService;

    public ReactiveHandler(){
        resultService = new ReactiveServiceImpl();
    }

    /**
     * get the result from service first, then trans the result to {@code ServerResponse}
     * @param serverRequest the req
     * @return the ServerResponse
     */
    public Mono<ServerResponse> extraResult(ServerRequest serverRequest) {
        //get the result from service
        //todo : do some check here.

        Mono<ResultViewModel> resultViewModelMono = resultService.extraResult(serverRequest);

        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        //trans to ServerResponse and return.
        //todo : too many code

        return resultViewModelMono.flatMap(new Function<ResultViewModel, Mono<ServerResponse>>() {
            @Override
            public Mono<ServerResponse> apply(ResultViewModel resultViewModel) {
                return ServerResponse
                        .ok()
                        .contentType(APPLICATION_JSON)
                        .body(fromObject(resultViewModel));
            }
        }).switchIfEmpty(notFound);
    }


    public Mono<ServerResponse> listResult(ServerRequest serverRequest){
        Flux<ResultViewModel> resultViewModelFlux=resultService.flowAllResult(serverRequest);
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(resultViewModelFlux,ResultViewModel.class);
    }

    public Mono<ServerResponse> createView(ServerRequest serverRequest){
        Mono<ResultViewModel> resultViewModelMono=resultService.putItem(serverRequest);
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(resultViewModelMono,ResultViewModel.class);
    }
}
