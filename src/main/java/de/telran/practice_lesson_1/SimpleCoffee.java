package de.telran.practice_lesson_1;

public class SimpleCoffee {
    public static void main(String[] args) {
        CoffeeAutomat aut1;
        aut1 = new CoffeeAutomat();

        aut1.setName("Ferrari");
        aut1.setCountTypeCoffee(10);
        aut1.setCountWater(10);

        aut1.putCoin(50);
        aut1.getCoffee();

        CoffeeAutomat aut2 = new CoffeeAutomat("Type1", 10, 10, true);

        aut2.putCoin(50);
        aut2.getCoffee();
    }
}
