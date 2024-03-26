package de.telran.summary1;

import java.util.Objects;

public class Car {

    private String model;

    private int id;

    private String colour;

    public Car(String model, int id, String colour) {
        this.model = model;
        this.id = id;
        this.colour = colour;
    }

    public static void main(String[] args) {
        Car car1 = new Car("BMW", 123, "white");
        Car car2 = new Car("BMW", 123, "white");

        String stringDescription = car1.toString();
//        System.out.println(car.toString());
        System.out.println(car1);

        System.out.println(car1 == car2);
        System.out.println(car1.equals(car2));

        System.out.println("ABC".equals("ABC"));
    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", id=" + id +
                ", colour='" + colour + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
//        return id == car.id && Objects.equals(model, car.model) && Objects.equals(colour, car.colour);
        return id == car.id;
    }

}
