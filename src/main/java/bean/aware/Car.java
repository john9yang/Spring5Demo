package bean.aware;

public class Car {
    private Wheel wheel;

    private Wheel2 wheel2;

    public Car(){
        System.out.println("Car constructed");
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        System.out.println("set wheel");
        this.wheel = wheel;
    }

    public Wheel2 getWheel2() {
        return wheel2;
    }

    public void setWheel2(Wheel2 wheel2) {
        System.out.println("set wheel2");
        this.wheel2 = wheel2;
    }
}
