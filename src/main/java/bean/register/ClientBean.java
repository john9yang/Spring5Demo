package bean.register;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientBean {
    @Autowired
    private AppBean appBean;

    public void doSomething(){
        appBean.process();
    }
}
