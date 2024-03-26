package de.telran.lection3.polymorphism;

public class Lamp implements Switchable{

    private boolean isOn;

    @Override
    public void on(boolean on) {
        isOn = on;
    }

    @Override
    public void checkState() {
        System.out.println("Lamp is " + ((isOn) ? "on" : "off"));
    }

}
