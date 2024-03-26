package de.telran.practice_lesson_8;

import java.util.Comparator;

public class AutoCompare implements Comparator<Auto> {
    @Override
    public int compare(Auto o1, Auto o2) {
        if (o1.getManufactureYear() < o2.getManufactureYear()) {
            return -1;
        }
        if (o1.getManufactureYear() > o2.getManufactureYear()) {
            return -1;

        } else return 0;

//        return o1.getManufactureYear() - o2.getManufactureYear();     не всегда корректно работает (в случае переполнения int)
    }
}
