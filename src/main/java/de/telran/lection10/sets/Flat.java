package de.telran.lection10.sets;

import java.util.Set;
import java.util.TreeSet;

public class Flat implements Comparable<Flat> {

    private String street;
    private int houseNumber;
    private int flatNumber;

    public Flat(String street, int houseNumber, int flatNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", flatNumber=" + flatNumber +
                '}';
    }


    public static void main(String[] args) {
        Flat flat1 = new Flat("Sadovaya", 2, 3);
        Flat flat2 = new Flat("Sadovaya", 2, 4);
        Flat flat3 = new Flat("Sadovaya", 1, 3);

        Set<Flat> flatSet = new TreeSet<>();
        flatSet.add(flat1);
        flatSet.add(flat2);
        flatSet.add(flat3);
        System.out.println(flatSet);
        System.out.println(flatSet.size());




    }

    @Override
    public int compareTo(Flat o) {
        int result = street.compareTo(o.street);
        if (result == 0) result = houseNumber - o.houseNumber;
        if (result == 0) result = flatNumber - o.flatNumber;
        return result;
    }
}
