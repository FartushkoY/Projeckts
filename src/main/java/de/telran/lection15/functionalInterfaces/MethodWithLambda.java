package de.telran.lection15.functionalInterfaces;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class MethodWithLambda {
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {6, 7, 8, 9, 10};

        Integer[] result = process(array1, array2, Integer::sum);
        System.out.println(Arrays.toString(result));

        result = process(array1, array2, (i, j) -> i * j);
        System.out.println(Arrays.toString(result));

        result = process(array1, array2, (i,j) -> (int) Math.pow(i, j));
        System.out.println(Arrays.toString(result));




    }

    public static Integer[] process(Integer[] array1, Integer[] array2, BinaryOperator<Integer> action) {
        if (array1.length != array2.length) throw new RuntimeException("Data is incorrect");

        Integer[] result = new Integer[array1.length];
        for (int i = 0; i < array1.length; i++) {
            Integer r = action.apply(array1[i], array2[i]);
            result[i] = r;
        }
        return result;
    }


}
