package de.telran.practice_lesson_27;

import java.util.concurrent.Callable;

public class TotalAmountTaxes implements Callable<Double> {
private Cafe.Meal[] meals;

    public TotalAmountTaxes(Cafe.Meal[] meals) {
        this.meals = meals;
    }

    @Override
    public Double call() throws Exception {
        Double totalTaxes = 0.0;
        for (Cafe.Meal meal: meals) {
            totalTaxes += meal.getPrice() * 0.45;
        }

        return totalTaxes;
    }
}
