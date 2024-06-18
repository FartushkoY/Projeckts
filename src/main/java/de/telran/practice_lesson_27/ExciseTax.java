package de.telran.practice_lesson_27;

import java.util.concurrent.Callable;

public class ExciseTax implements Callable<Double> {
    private Cafe.Meal[] meals;

    public ExciseTax(Cafe.Meal[] meals) {
        this.meals = meals;
    }


    @Override
    public Double call() throws Exception {
        Double exiseTax = 0.0;
        for (Cafe.Meal meal: meals) {
            if (meal.getType() == 3) {
                exiseTax += meal.getPrice() * 0.02;
            }
        }
        return exiseTax;
    }
}
