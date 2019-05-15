package entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//运行环境
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})//指定文件配置
public class HelloSpringTest {

    @Test
    public void sayHello(){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloSpring helloSpring = context.getBean("helloSpring",HelloSpring.class);
        System.out.println(helloSpring.sayHello());

        BeanDefinition beanDefinition = context.getBeanFactory().getBeanDefinition("helloSpring");
        System.out.println(beanDefinition.getAttribute("name"));
    }

    @Test
    public void testMethodReplaced(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestChangeMethod testChangeMethod = context.getBean("testChangeMethod",TestChangeMethod.class);
        testChangeMethod.changeMe();
    }
}