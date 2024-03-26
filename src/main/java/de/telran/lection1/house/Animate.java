package de.telran.lection1.house;

public abstract class Animate extends Creature {

    private int age;
    public Animate(String name, int age) {
        super(name);
        this.age = age;
    }

    public void grow() {
        age = getAge() + 1;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
