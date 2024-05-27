package de.telran.summary10;

import org.junit.jupiter.api.Test;

import java.util.*;


public class Tasks {
    public static List<String> findDublicates(String text) {
        List<String> result = new ArrayList<>();
        if (text == null || (text.isEmpty())) return result;
        String[] stringArray = text.toLowerCase().split("[\\W]+");
        for (int i = 0; i < stringArray.length - 1; i++) {
            if (stringArray[i].matches("[a-zA-Z]+") && stringArray[i].matches(stringArray[i + 1])) {
                result.add(stringArray[i]);
            }
        }
        return result;
    }


    public static int findSecondMax(int[] array) {

        if (array == null || array.length < 2) throw new IllegalArgumentException("Input data is not valid");
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : array) {
            if (num >= max) {
                secondMax = max;
                max = num;
            } else if (num >= secondMax) {
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


