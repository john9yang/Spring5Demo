package bean.lookup;

import entity.User;

public abstract class GetBeanTest {
    public void showMe(){
        this.getBean().showMe();
    }

    public abstract User getBean();
}