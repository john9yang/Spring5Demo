package bean.register;

import org.springframework.beans.factory.BeanNameAware;

public class AppBean implements BeanNameAware {
    private String str;

    public AppBean(){
        System.out.println("AppBean Constructed");
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void process(){
        System.out.println(str);
    }


    @Override
    public void setBeanName(String name) {

    }
}
