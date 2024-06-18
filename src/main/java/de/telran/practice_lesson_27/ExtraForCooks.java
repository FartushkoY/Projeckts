package de.telran.practice_lesson_27;

import java.util.concurrent.Callable;

public class ExtraForCooks implements Callable<Double> {

    Cafe.Meal[] meals;

    public ExtraForCooks(Cafe.Meal[] meals) {
        this.meals = meals;
    }

    @Override
    public Double call() throws Exception {
        Double extraForCooks = 0.0;
        for (Cafe.Meal meal : meals) {
            if (meal.getType() == 2) {
                extraForCooks += meal.getPrice() * 0.1;
            }
        }
        return extraForCooks;
    }
}
