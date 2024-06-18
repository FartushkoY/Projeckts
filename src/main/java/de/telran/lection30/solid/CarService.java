package de.telran.lection30.solid;

public interface CarService {



    default void service(Car car) {
        System.out.println("Default actions");
    }
}
