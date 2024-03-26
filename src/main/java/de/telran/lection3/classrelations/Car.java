package de.telran.lection3.classrelations;

public class Car {

    private final Motor motor = new Motor(); // composition

    private Driver driver; // aggregation

    public Car(Driver driver) {
        this.driver = driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }


    public static void main(String[] args) {
        Driver tom = new Driver();
        Car car = new Car(tom);
        car.setDriver(new Driver());
    }
}
