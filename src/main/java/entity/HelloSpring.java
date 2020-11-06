package entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class HelloSpring implements InitializingBean, DisposableBean {
    private String value;

    public HelloSpring(){
        System.out.println("HelloSpring construct");
    }

    public String sayHello(){
        return "Hello Spring";
    }

    public void init(){
        System.out.println("HelloSpring Init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    public void over(){
        System.out.println("Over");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        System.out.println("HelloSpring setValue");
        this.value = value;
    }
}