package de.telran.selfWork.thatIsLife;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private Human driver;

    private List<Human> passengers = new ArrayList<>();

    public Car() {
    }

    public Car(Human driver) {
        this.driver = driver;
    }

    public Car(Human driver, List<Human> passengers) {
        this.driver = driver;
        this.passengers = passengers;
    }


}
