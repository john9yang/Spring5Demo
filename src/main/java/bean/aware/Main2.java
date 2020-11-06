package bean.aware;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main2 {
    public static void main(String[] args) {
        Resource resource;
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        Car car = (Car)beanFactory.getBean("car");
        System.out.println("wheel:"+car.getWheel());
        System.out.println("wheel2:"+car.getWheel2());
    }
}
