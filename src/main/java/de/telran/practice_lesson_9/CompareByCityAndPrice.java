package de.telran.practice_lesson_9;

import java.util.Comparator;

public class CompareByCityAndPrice implements Comparator<House> {

    @Override
    public int compare(House o1, House o2) {
        int result = o1.getCity().compareTo(o2.getCity());
        if (result == 0) result = Integer.compare(o1.getPrice(), o2.getPrice());
        return result;
    }
}
