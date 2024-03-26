package de.telran.lection3.polymorphism;

public class Switcher {

    private Switchable switchable;

    public Switcher(Switchable switchable) {
        this.switchable = switchable;
    }

    public void switchOn() {
        switchable.on(true);
    }

    public void switchOff() {
        switchable.on(false);
    }

    public Switchable getSwitchable() {
        return switchable;
    }

    public void setSwitchable(Switchable switchable) {
        this.switchable = switchable;
    }

    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Switcher switcher = new Switcher(lamp);
        switcher.switchOn();
        lamp.checkState();
        switcher.switchOff();
        lamp.checkState();

        LightBulb lightBulb = new LightBulb();
        switcher.setSwitchable(lightBulb);
        switcher.switchOn();
        lightBulb.checkState();
        switcher.switchOff();
        lightBulb.checkState();
    }

}
