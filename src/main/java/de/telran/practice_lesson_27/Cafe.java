package de.telran.practice_lesson_27;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Cafe {

    public static class Meal {
        private String title;
        private int type;
        private double price;

        public Meal(String title, int type, double price) {
            this.title = title;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Meal{" +
                    "title='" + title + '\'' +
                    ", type=" + type +
                    ", price=" + price +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random = new Random();

        Meal[] meals = new Meal[100];
        for (int i = 0; i < 100; i++) {
            meals[i] = new Meal("meal" + i, random.nextInt(1,4), random.nextDouble(10, 100));
        }
//        System.out.println(Arrays.toString(meals));

        FutureTask<Double> futureTotalAmountTaxes = new FutureTask<>(new TotalAmountTaxes(meals));
        FutureTask<Double> futureExciseTaxes = new FutureTask<>(new ExciseTax(meals));
        FutureTask<Double> futureSnacksTaxes = new FutureTask<>(new Snacks(meals));
        FutureTask<Double> futureExtraForCooks = new FutureTask<>(new ExtraForCooks(meals));

        new Thread(futureTotalAmountTaxes).start();
        new Thread(futureExciseTaxes).start();
        new Thread(futureSnacksTaxes).start();
        new Thread(futureExtraForCooks).start();
        System.out.println(futureTotalAmountTaxes.get());
        System.out.println(futureExciseTaxes.get());
        System.out.println(futureSnacksTaxes.get());
        System.out.println(futureExtraForCooks.get());

        double sum = Arrays.stream(meals).mapToDouble(m -> m.getPrice()).sum();
        System.out.println(sum);
        System.out.println(sum - futureTotalAmountTaxes.get() - futureExciseTaxes.get() - futureSnacksTaxes.get() - futureExtraForCooks.get());


    }
}
