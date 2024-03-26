package de.telran.summary1.superherobattle;

import java.util.Random;

public class EvilCreature extends Character{

    private int force;
	private int protection;
    private static int randomEvilcount = 1;

    public EvilCreature(String name, int force, int protection) {
        super(name);
        this.force = force;
        this.protection = protection;
    }

    public static EvilCreature generateRandomEvilCreature() {
        String name = "RandomEvilCreature" + randomEvilcount;
        int randomProtection = new Random().nextInt(10);
        int randomForce = new Random().nextInt(91) + 10;
        EvilCreature randomEvilCreature = new EvilCreature(name, randomForce, randomProtection);
        randomEvilcount++;
        return randomEvilCreature;

    }

    @Override
    public String toString() {
        return "EvilCreature{name=" + getName() +
                ", force=" + force +
                ", protection=" + protection + ", health=" + getHealth() +
                '}';
    }

    @Override
    public int countForce() {
        return force;
    }

    @Override
    public int countProtection() {
        return protection;
    }
}
