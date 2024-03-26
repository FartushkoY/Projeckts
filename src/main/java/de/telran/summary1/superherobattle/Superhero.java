package de.telran.summary1.superherobattle;

public class Superhero extends Character {

    private int force;
	private Weapon weapon;
	private Protection protection;

    public Superhero(String name, int force, Weapon weapon, Protection protection) {
        super(name);
        this.force = force;
        this.weapon = weapon;
        this.protection = protection;
    }

    @Override
    public String toString() {
        return "Superhero{name=" + getName() +
                ", force=" + force +
                ", weapon=" + weapon +
                ", protection=" + protection + ", health=" + getHealth() +
                '}';
    }

    @Override
    public int countForce() {
        return force + weapon.getForce();
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    @Override
    public int countProtection() {
        return protection.getLevel();
    }



}
