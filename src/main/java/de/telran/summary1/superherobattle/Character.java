package de.telran.summary1.superherobattle;

public abstract class Character {
    private String name;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        health = getHealth();
    }

    public void introduce() {
        System.out.println("Hello! My name is " + name + ".");
    }

    public abstract int countForce();

    public abstract int countProtection();

    public final int fight(Character another) {
        int thisForce = countForce();
        int anotherForce = another.countForce();
        if (thisForce > anotherForce) {
            health = health - (thisForce - anotherForce) / another.countProtection();
            System.out.println(name + " wins !");
        } else if (anotherForce > thisForce) {
            another.health = another.health - (anotherForce - thisForce) / countProtection();
            System.out.println(another.name + " wins !");
        } else {
            System.out.println("Nobody won!");
        }
        return health;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = (int) health;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                '}';
    }
}
