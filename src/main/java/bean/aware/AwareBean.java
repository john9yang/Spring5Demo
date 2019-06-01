package bean.aware;

import entity.HelloSpring;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class AwareBean implements BeanFactoryAware, BeanNameAware{
    private BeanFactory beanFactory;

    private String beanName;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public String testAwareBeanFactory(){
        HelloSpring helloSpring = (HelloSpring)beanFactory.getBean("helloSpring");
        return helloSpring.sayHello();
    }

    public String getBeanName() {
        return beanName;
    }
}