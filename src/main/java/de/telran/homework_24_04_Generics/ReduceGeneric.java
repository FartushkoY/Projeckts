package de.telran.homework_24_04_Generics;

import de.telran.summary6.Task;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceGeneric {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Double> doubles = Arrays.asList(1.2, 3.3, 4.0, 6.1, 7.00);
        List<String> strings = Arrays.asList("A", "B", "C", "D", "E");
        List<Boolean> booleans = Arrays.asList(true, true, false, true, false);

        System.out.println(reduceGeneric(integers, (i, j) -> i + j, 0));
        System.out.println(reduceGeneric(strings, (s1, s2) -> s1 + s2, "TEST"));
        System.out.println(reduceGeneric(doubles, (i, j) -> i * j, 1.0));
        System.out.println(reduceGeneric(booleans, (b1, b2) -> b1 == b2, false));

    }

    public static <T> T reduceGeneric(List<T> list, BinaryOperator<T> operator, T basicValue) {
        T result = basicValue;
        for (T element : list) {
            result = operator.apply(result, element);
        }
        return result;
    }
}
