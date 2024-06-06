package de.telran.Algorithms.lesson_04_06;

import java.util.ArrayList;
import java.util.List;

public class Tasks {

    public static void main(String[] args) {
        int[] array1 = {1, 5, 12, 20};
        int[] array2 = {1, 5, 4, 20};
        int[] array3 = {7};
        int[] array4 = new int[0];
        int[] array5 = {100, 50, 7, 7};

        System.out.println(checkAscending(array1));
        System.out.println(checkAscending(array2));
        System.out.println(checkAscending(array3));
        System.out.println(checkAscending(array4));


        // Задача 2
        // Определить, является ли массив возрастающим, убывающим или неотсортированным (3 состояния):
        // 1 - возрастающий, -1 - убывающий, 0 - неотсортированный
        // Массив может содержать одинаковые элементы

        System.out.println(checkSortMode(array1));
        System.out.println(checkSortMode(array2));
        System.out.println(checkSortMode(array5));
        System.out.println(checkSortMode(array4));

//        Задача 3
        // Найти максимальныю длину возрастающей последовательности в неотсортированном массиве
        int[] array6 = {1, 5, 3, 4, 7, 2, 3, 4, 5, 6, 7};
        System.out.println(maxAcsendingLength(array6));
    }

    public static boolean checkAscending(int[] array) {
        boolean result = true;
        if (array.length <= 1) return true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return result;
    }

    public static int checkSortMode(int[] array) {
        int result = 1;
        if (array.length == 0) return result;
        if (array[0] < array[1]) {
            for (int i = 1; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    return 0;
                }
            }
        } else {
            result = -1;
            for (int i = 1; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    return 0;
                }
            }
        }
        return result;
    }

    public static int maxAcsendingLength(int[] array) {
        int counter = 1;
        int maxCounter = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                counter++;
                if (counter > maxCounter) {
                    maxCounter = counter;
                }
            } else {
                counter = 1;
            }
        }
        return maxCounter;
    }
}

