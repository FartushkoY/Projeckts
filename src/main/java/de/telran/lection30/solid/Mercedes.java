package de.telran.lection30.solid;

import lombok.ToString;

@ToString
public class Mercedes extends Car{

    @Override
    public void move() {

    }

    @Override
    public CarService getCarService() {
        return new MercedesService();
    }


//    @Override
//    public void service() {
//        System.out.println("Servicing mercedes " + this);
//    }
}
