package de.telran.practice_lesson_17;

import java.util.Arrays;
import java.util.List;

public class Concert <T extends Actor>{
    private List<T> t;

    public Concert(T ... t) {
        this.t = Arrays.stream(t).toList();
    }
    public Concert(List<T> t) {
        this.t = t;
    }

    public void process() {
        for (T acter : t) {
            acter.showTalant();
        }
    }


}
