package de.telran.homework_15_04_FunctionalInterfaces;


import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Function<Integer, Integer> f1 = (i) -> i * 10;
        Function<Integer, String> f2 = (i) -> "<<" + i + ">>";
        Function<String, Integer> f3 = String::length;

        Function<Integer, Integer> compositeFunction1 = f1.andThen(f2).andThen(f3);
        System.out.println(compositeFunction1.apply(777));

        Function<String, String> compositeFunction2 = f3.andThen(f1).andThen(f2);
        System.out.println(compositeFunction2.apply("Hello!"));

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(reduce(integerList, Integer::sum, 0));
        System.out.println(reduce(integerList, (i, j) -> j * i, 1));
    }

    public static Integer reduce(List<Integer> list, BinaryOperator<Integer> operator, Integer basicValue) {
        Integer result = basicValue;
        for (int i = 0; i < list.size(); i++) {
            result = operator.apply(result, list.get(i));
        }
        return result;
    }
}


