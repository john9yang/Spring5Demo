package bean.register;

import org.springframework.stereotype.Component;

public class FooService {
    private  final  BarService barService;

    public FooService(BarService barService){
        this.barService=barService;
    }
}