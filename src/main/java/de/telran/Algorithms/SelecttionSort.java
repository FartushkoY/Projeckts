package de.telran.Algorithms;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.Arrays;

public class SelecttionSort {
    public static void main(String[] args) {
        int[] array = {5, 8, 15, 4, 1, 9, 2, 0, -7, -4};
        System.out.println(Arrays.toString(selectionSort(array)));
    }


    public static int[] selectionSort(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length) {
            int indexMin = getMin(array, startIndex);
            int min = array[indexMin];
            for (int j = indexMin; j > startIndex; j--) {
                array[j] = array[j - 1];
            }
            array[startIndex] = min;
            startIndex++;
        }
        return array;
    }

    public static int getMin(int[] array, int startIndex) {
        int min = Integer.MAX_VALUE;
        int indexMin = 0;
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                indexMin = i;
            }
        } return indexMin;
    }
}

