package de.telran.practice_lesson_17;

import java.util.List;

public class SimpleConcert {
    public static void main(String[] args) {
        Singer singer1 = new Singer("Sting");
        Singer singer2 = new Singer("Madonna");
        Singer singer3 = new Singer("Monatik");
        Dancer dancer1 = new Dancer("Kot");
        Dancer dancer2 = new Dancer("Kolyadenko");
        Dancer dancer3 = new Dancer("Ilona");

        List<Actor> concert1 = List.of(singer1, dancer1, singer2, dancer2, singer3, dancer3);
        Concert<Actor> concerts = new Concert<>(concert1);
        concerts.process();
//        Concert<Actor> concert = new Concert<>(singer1);
//        concert.process();
//        Concert<Actor> concert2 = new Concert<>(dancer1);
//        concert2.process();
        System.out.println("---------------");
        Concert<Actor> concert2 = new Concert<>(dancer1, singer1, singer2);
        concert2.process();

        singer1.eat();

    }



}
