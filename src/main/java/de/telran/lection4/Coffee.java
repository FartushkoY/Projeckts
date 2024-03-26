package de.telran.lection4;

public enum Coffee {

    CAPPUCCINO("Cappuccino", 3.5),
    LATTE("Latte", 2.5),
    AMERICANO("Americano", 2),
    ESPRESSO("Espresso", 2),
    MACCHIATO("Macchiato", 3);


    private String description;
    private double price;

    Coffee(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name() + "{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
