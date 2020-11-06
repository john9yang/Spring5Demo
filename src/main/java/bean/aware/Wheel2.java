package bean.aware;

import org.springframework.beans.factory.BeanNameAware;

public class Wheel2 implements BeanNameAware{
    private String beanName;

    public Wheel2(){
        System.out.println("Wheel Constructed");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
