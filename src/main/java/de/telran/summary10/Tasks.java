package de.telran.summary10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Tasks {
    public static List<String> findDublicates(String text) {
        return null;

    }

    public static int findSecondMax(int[] array) {

        if (array == null || array.length < 2) throw new IllegalArgumentException("Input data is not valid");
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : array) {
            if (num >= max) {
                secondMax = max;
                max = num;
            }
            else if (num >= secondMax) {
                secondMax = num;
            }
        }
        return secondMax;

    }
    public static int findSecondMaxWithStream(int[] array) {
        if (array == null || array.length < 2) throw new IllegalArgumentException("Input data is not valid");
        int result = Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow(() -> (new IllegalArgumentException("Input data is not valid")));
        return result;
    }
}


