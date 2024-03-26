package de.telran.lection3.classrelations;

public class Chicken {

    private Egg egg;

    public Chicken() {
//        this.egg = new Egg();
    }

    public void setEgg(Egg egg) {
        this.egg = egg;
    }

    public static void main(String[] args) {
        Chicken someChicken = new Chicken();
        Egg someEgg = new Egg();
        someChicken.setEgg(someEgg);
        someEgg.setChicken(someChicken);

        System.out.println(someChicken);
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "egg=" + egg +
                '}';
    }
}
