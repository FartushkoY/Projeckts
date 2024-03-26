package de.telran.summary4.Task.figures;

public class Triangle extends Figure {
    private double cathetus1;
    private double cathetus2;

    public Triangle(double cathetus1, double cathetus2) {
        this.cathetus1 = cathetus1;
        this.cathetus2 = cathetus2;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "cathetus1=" + cathetus1 +
                ", cathetus2=" + cathetus2 +
                '}';
    }


    @Override
    public double getArea() {
        return cathetus1 * cathetus2 / 2;
    }
}
