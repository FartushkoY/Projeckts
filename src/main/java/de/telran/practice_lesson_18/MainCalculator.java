package de.telran.practice_lesson_18;

public class MainCalculator {
    public static void main(String[] args) {
        NumeralOperations<Integer> calculator = new CalculatorInteger();
        System.out.println(calculator.add(10, 15));
        System.out.println(calculator.sub(10, 15));
        System.out.println(calculator.multi(10, 15));
        System.out.println(calculator.div(10, 15));

        NumeralOperations<Long> calculator2 = new CalculatorLong();
        System.out.println(calculator2.add(10L, 15L));
        System.out.println(calculator2.sub(10L, 15L));
        System.out.println(calculator2.multi(10L, 15L));
        System.out.println(calculator2.div(10L, 15L));


        NumeralOperations<Double> calculator3 = new CalculatorDouble();
        System.out.println(calculator3.add(10.5, 15.6));
        System.out.println(calculator3.sub(10.5, 15.6));
        System.out.println(calculator3.multi(10.5, 15.6));
        System.out.println(calculator3.div(10.5, 15.6));


    }
}
