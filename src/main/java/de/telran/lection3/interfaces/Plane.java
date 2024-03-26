package de.telran.lection3.interfaces;

public class Plane extends Item implements Flyable{

    @Override
    public void fly(){
        System.out.println("Plane flies");
    }
}