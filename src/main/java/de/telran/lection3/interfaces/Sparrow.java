package de.telran.lection3.interfaces;

public class Sparrow extends Bird implements Flyable, Chirikable {

    @Override
    public void fly(){
        System.out.println("Sparrow flies");
    }

    @Override
    public void chirik() {
        System.out.println("Chik-chirik!");
    }

    @Override
    public void makeSomeSound() {
        System.out.println("Sparrow sings");
    }
}