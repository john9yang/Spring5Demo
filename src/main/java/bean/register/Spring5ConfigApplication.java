package bean.register;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
@Import(MyBeanRegistrar.class)
public class Spring5ConfigApplication {

    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(Spring5ConfigApplication.class);
        System.out.println(ac.getBean(FooService.class));
        System.out.println(ac.getBean(BarService.class));
        ClientBean clientBean = ac.getBean(ClientBean.class);
        clientBean.doSomething();
    }

//    @Bean  //新加bean BarService
//    BarService barService(){
//        return new BarService();
//    }

    @Bean
    ClientBean clientBean(){
        return new ClientBean();
    }
}