package bean.postprocessor;

import entity.HelloSpring;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class HelloSpringBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ( bean instanceof HelloSpring)
            System.out.println("postProcessBeforeInitialization:"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ( bean instanceof HelloSpring)
            System.out.println("postProcessAfterInitialization:"+beanName);
        return bean;
    }

}
