package entity;

public class Teacher extends User {

    public Teacher(){
        System.out.println("Teacher contructed");
    }

    @Override
    public void showMe() {
        System.out.println("I am teacher");
    }
}