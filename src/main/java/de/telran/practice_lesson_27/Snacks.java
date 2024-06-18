package de.telran.practice_lesson_27;

import java.util.concurrent.Callable;

public class Snacks implements Callable<Double> {
    Cafe.Meal[] meals;

    public Snacks(Cafe.Meal[] meals) {
        this.meals = meals;
    }

    @Override
    public Double call() throws Exception {
        Double snackTax = 0.0;
        for (Cafe.Meal meal : meals) {
            if (meal.getType() == 2) {
                snackTax += meal.getPrice() * 0.01;
            }
        }
        return snackTax;
    }
}
