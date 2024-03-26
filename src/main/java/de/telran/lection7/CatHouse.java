package de.telran.lection7;

public class CatHouse {

    public static void main(String[] args) {
        Cat cat = new Cat("Cat");
        Cat.Kitten kitten1 = cat.new Kitten("Kitten1");
        Cat.Kitten kitten2 = cat.new Kitten("Kitten2");

        System.out.println(kitten1);
        System.out.println(kitten2);

        Cat cat2 = new Cat("Cat 2");
        Cat.Kitten kitten3 = cat.new Kitten("Kitten3");



    }
}
