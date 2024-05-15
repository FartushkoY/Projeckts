package de.telran.lection1.house;

public class Cat extends Animal implements Mousetrap, Comparable<Cat>{

    public Cat(String catName) {
        this(catName, 1,  "white");
    }

    public Cat(String catName, int catAge, String catColour) {
        super(catName, catAge, catColour,  true);
    }


    @Override
    public void sayHello() {
        System.out.println("Meow! I'm cat. My name is " + super.getName());
    }

    @Override
    public void play(Creature another) {
        if (another instanceof Dog) {
            System.out.println("Cat " + super.getName() + " is playing with dog " + another.getName() + ". Cat running away.");
        } else {
            System.out.println(super.getName() + " play with " + another.getName());
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + getName() + '\'' +
                '}';
    }

    public void meow() {
        System.out.println("Meow!");
    }

    @Override
    public void catchMouse(Mouse mouse) {
        System.out.println(getName() + " catch Mouse " + mouse.getName());
    }

    @Override
    public int compareTo(Cat o) {
        int result = this.getName().compareTo(o.getName());
        if (result == 0) {
            result = Integer.compare(this.getAge(), o.getAge());
        }
        if (result == 0) {
            result = this.getColour().compareTo(o.getColour());
        }
        if (result == 0) {
            result = Boolean.compare(this.isHungry(), o.isHungry());
        }
        return result;
    }
}
