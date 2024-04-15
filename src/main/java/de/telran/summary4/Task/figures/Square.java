package de.telran.summary4.Task.figures;



public class Square extends Rectangle implements Comparable<Square>{

    public Square(double side1) {
        super(side1, side1);
    }

    @Override
    public int compareTo(Square o) {
        return Double.compare(getSide1(), o.getSide1());
    }
}
