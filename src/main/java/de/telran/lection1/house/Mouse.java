package de.telran.lection1.house;

public class Mouse extends Animal{


    public Mouse(String name, int age, String colour) {
        super(name, age, colour, true);
    }

    @Override
    public void sayHello() {
        System.out.println("Pee-pee! I'm mouse. My name is " + super.getName());
    }
}
