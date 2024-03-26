package de.telran.lection4;

public class CoffeeMachine {
private double money;
private double currentMoneyInMashine = 0;


    public void displayInfo(Coffee coffee) {
        System.out.println(coffee.getDescription() + " price " + coffee.getPrice());
    }

    public static void makeCoffee(Coffee coffee, double money){
        if (coffee == Coffee.CAPPUCCINO) {
            System.out.println("No CAPPUCCINO in coffee mashine. Take back the money " + money);
        } else {

            System.out.println("You choose coffee " + coffee + ". Price " + coffee.getPrice() + ". Put the money");
            if (money == coffee.getPrice()) {
                System.out.println("Make " + coffee);
            } else if (money > coffee.getPrice()) {
                System.out.println("Make " + coffee + ". Tacke your change " + (money - coffee.getPrice()));
                ;
            } else {
                System.out.println("Not enough money. Take back the money " + money);
            }
        }

    }

    public void getMoneyBack() {
        System.out.println("Take your money " + currentMoneyInMashine);
        currentMoneyInMashine = 0;
    }





    public static void main(String[] args) {
        makeCoffee(Coffee.LATTE,5);
    }
}
