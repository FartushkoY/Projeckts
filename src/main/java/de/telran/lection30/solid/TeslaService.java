package de.telran.lection30.solid;

public class TeslaService implements CarService{
    @Override
    public void service(Car car) {
        System.out.println("Installing new batteries for " + car);
    }
}
