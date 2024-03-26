package de.telran.lection1.house;

public class Human extends Animate implements Walking {



    public Human(String name, int age) {
        super(name, age);
    }


    public void feedAnimal(Animal animal) {
        animal.feed();
    }

    public void feedAnimal(Animal... animals) {
        for (Animal a : animals) {
            a.feed();
        }
    }

    @Override
    public void sayHello() {
        System.out.println("Hello! My name is " + super.getName() + "I am is human.");
    }

    @Override
    public void walkAnimal(Animal animal) {
        System.out.println(getName() + " walking with " + animal.getName());
        animal.setHungry(true);
    }


}
