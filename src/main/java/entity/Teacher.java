package entity;

public class Teacher extends User {

    @Override
    public void showMe() {
        System.out.println("I am teacher");
    }
}