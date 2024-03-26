package de.telran.lection1.house;

public class Dog extends Animal {

    public Dog(String name, int age, String colour) {
        super(name, age, colour, true);
    }

    @Override
    public void sayHello() {
        System.out.println("Gav! I'm dog. My name is " + super.getName());
    }

    public void bark() {
        System.out.println("Gav! Gav!");
    }

    @Override
    public void play(Creature another) {
       if (another instanceof Cat) {
           System.out.println("Dog " + super.getName() + " is playing with cat " + another.getName() + ".");
           bark();
       } else {
           System.out.println(this.getName() + " play with " + another.getName());
       }
    }
}
