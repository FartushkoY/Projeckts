package de.telran.lection30.solid;

import lombok.ToString;

@ToString
public class Tesla extends Car{
    @Override
    public void move() {

    }

    @Override
    public CarService getCarService() {
        return new TeslaService();
    }


}
