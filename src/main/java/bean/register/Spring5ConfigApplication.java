package bean.register;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class Spring5ConfigApplication {

    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(Spring5ConfigApplication.class);
    }

//    @Bean  //新加bean BarService
//    BarService barService(){
//        return new BarService();
//    }
}