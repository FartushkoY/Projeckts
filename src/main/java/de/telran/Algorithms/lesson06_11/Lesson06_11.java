package de.telran.Algorithms.lesson06_11;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lesson06_11 {

    public static String convertArrayToRangesString(int[] array) {
        Arrays.sort(array);
        int start = array[0];
        int end = array[0];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] > array[i] + 1) {
                end = array[i];
                if (end == start) {
                    result.append(start).append(", ");
                } else {
                    result.append(start).append("-").append(end).append(", ");
                }
                start = array[i + 1];
            }
            end = array[i + 1];
        }
        if (start == end) {
            result.append(start);
        } else {
            result.append(start).append("-").append(end);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 5, 3, 4, 7, 2};
        // Output: "1-5,7"
        int[] arr2 = {5, 3, 4, 7, 2, 15, 14, 16, 9, 8};
        // Output: "2-5,7-9,14-16"
        int[] arr3 = {5, 3, 4, 7, 2, 15, 14, 16, 9};
        // Output: "2-5,7,9,14-16"
        System.out.println(convertArrayToRangesString(arr1));
        System.out.println(convertArrayToRangesString(arr2));
        System.out.println(convertArrayToRangesString(arr3));


    }
}
