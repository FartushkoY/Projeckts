package de.telran.summary1.superherobattle;

public class SuperheroBattle {
    public static void main(String[] args) {

        Superhero superhero1 = new Superhero("Iron Man", 50, new Weapon("Iron", 55), new Protection("Armor", 7));
        Superhero superhero2 = new Superhero("Thor", 55, new Weapon("Thunder", 45), new Protection("Mjolnir", 5));

        EvilCreature evilCreature1 = new EvilCreature("Lockie", 20, 5);
        EvilCreature evilCreature2 = new EvilCreature("Thanos", 53, 6);

        superhero1.introduce();
        superhero2.introduce();
        evilCreature1.introduce();
        evilCreature2.introduce();

        superhero1.fight(evilCreature1);
        System.out.println(superhero1.getHealth());
        System.out.println(evilCreature1.getHealth());

        EvilCreature randomEvilCreature1 = EvilCreature.generateRandomEvilCreature();
        EvilCreature randomEvilCreature2 = EvilCreature.generateRandomEvilCreature();
        randomEvilCreature1.introduce();
        randomEvilCreature2.introduce();
        System.out.println(randomEvilCreature1);
        System.out.println(randomEvilCreature2);
        randomEvilCreature1.fight(randomEvilCreature2);
        System.out.println(randomEvilCreature1.getHealth());
        System.out.println(randomEvilCreature2.getHealth());
        randomEvilCreature1.fight(randomEvilCreature2);
        randomEvilCreature1.fight(randomEvilCreature2);
        randomEvilCreature1.fight(randomEvilCreature2);
        randomEvilCreature1.fight(randomEvilCreature2);
        System.out.println(randomEvilCreature1.getHealth());
        System.out.println(randomEvilCreature2.getHealth());

        Mag mag1 = new Mag("Marlin", 73, 5, 120);
        mag1.heal(evilCreature1);
        System.out.println(evilCreature1.getHealth());
        Character[] characters = {superhero1, evilCreature2, randomEvilCreature1};
        mag1.heal(characters);
        System.out.println("Health of " + superhero1.getName() + " - " + superhero1.getHealth() + ". Health of " +
                evilCreature2.getName() + " - " + evilCreature2.getHealth() + ". Health of " +
                randomEvilCreature1.getName() + " - " + randomEvilCreature1.getHealth());



    }
}
