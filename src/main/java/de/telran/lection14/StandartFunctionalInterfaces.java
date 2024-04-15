package de.telran.lection14;

import java.util.Random;
import java.util.function.*;

public class StandartFunctionalInterfaces {
    public static void main(String[] args) {



        // data1 -> data2 --- Function --- UnaryOperator --- .apply
        Function<String, String> upperCaseWithFunction = (s) -> s.toUpperCase();
        String result = upperCaseWithFunction.apply("String data");
        System.out.println(result);

        UnaryOperator<String> upperCaseOperator = (s) -> s.toUpperCase();
        result = upperCaseOperator.apply("String data");
        System.out.println(result);

        // void -> result --- Suplier (генератор данных) -- .get
        Supplier<Integer> randomGenerator = () -> new Random().nextInt();

        System.out.println(randomGenerator.get());
        System.out.println(randomGenerator.get());
        System.out.println(randomGenerator.get());

        // data -> void  --- Consumer (потребитель данных) ---- .accept
        Consumer<String> printData = (data) -> System.out.println(data);
        printData.accept("Data to consumer 1");
        printData.accept("Data to consumer 2");
        printData.accept("Data to consumer 3");



        // data -> boolean --- Predicate
        Predicate<String> isLongEnough = (s) -> s.length() > 3;
        System.out.println(isLongEnough.test("Test string"));
        System.out.println(isLongEnough.test("abc"));

        // (data1, data2) ->data3 --- BiFunction (принимает 2 аргумента)  --
        // - BinaryOperator(принимает 1 аргумент) ---   apply
        BinaryOperator<Integer> sum = (int1, int2) -> int1 + int2;
        System.out.println(sum.apply(10, 20));

        BiFunction<String, Integer, String> prepareData = (string, integer) -> string + ": " + integer;
        String preparedData = prepareData.apply("Number", 10);
        System.out.println(preparedData);
        preparedData = prepareData.apply("Number", 20);
        System.out.println(preparedData);
    }
}
