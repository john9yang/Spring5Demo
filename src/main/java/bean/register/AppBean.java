package bean.register;

public class AppBean {
    private String str;

    public void setStr(String str) {
        this.str = str;
    }

    public void process(){
        System.out.println(str);
    }
}
