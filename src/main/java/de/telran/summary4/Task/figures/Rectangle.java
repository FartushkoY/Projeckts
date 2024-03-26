package de.telran.summary4.Task.figures;

public class Rectangle extends Figure {
    private double side1;
    private double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                '}';
    }

    public double getSide1() {
        return side1;
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }


}
