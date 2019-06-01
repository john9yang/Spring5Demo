package bean.aware;

import entity.HelloSpring;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloSpring helloSpring = context.getBean("helloSpring",HelloSpring.class);
        System.out.println(helloSpring.sayHello());
        context.close();
    }
}
