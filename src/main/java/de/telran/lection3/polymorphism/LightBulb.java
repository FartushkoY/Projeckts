package de.telran.lection3.polymorphism;

public class LightBulb implements Switchable {

    private boolean isOn;

    @Override
    public void on(boolean on) {
        isOn = on;
    }

    @Override
    public void checkState() {
        System.out.println("LightBulb is " + ((isOn) ? "on" : "off"));
    }
}
