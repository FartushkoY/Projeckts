package de.telran.lection11;

import java.util.EnumSet;
import java.util.Set;

public class SetWithEnums {

    public enum Colour {
        RED, GREEN, WHITE, BLACK
    }


    public static void main(String[] args) {

//        EnumSet<Colour> availableColours = EnumSet.noneOf(Colour.class);
        Set<Colour> availableColours = EnumSet.noneOf(Colour.class);
        availableColours.add(Colour.BLACK);
        availableColours.add(Colour.WHITE);
        availableColours.add(Colour.GREEN);

        if (availableColours.contains(Colour.WHITE)) {
            System.out.println("White colour is available");
        }


    }

}
