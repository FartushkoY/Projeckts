package de.telran.summary4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchExamples {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 1, 3, 3, 3, 6, 6, 7, 9));
        System.out.println(Collections.binarySearch(integerList, 3));

        // Напишите метод, чтобы получить первое и последнее вхождение указанного элемента в упорядоченном списке.

        List<String> stringList = new ArrayList<>(Arrays.asList("A", "B", "B", "B", "B", "B", "B", "D"));
//        Collections.sort(stringList);
        System.out.println(stringList);
        System.out.println(binarySearch(stringList, "B")); // log(n)
        System.out.println(binarySearchFirst(stringList, "B")); // log(n)
        System.out.println(binarySearchLast(stringList, "B")); // log(n)
    }

    public static int binarySearch(List<String> list, String value) {
        int startIndex = 0;
        int endIndex = list.size() - 1;

        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            String current = list.get(middleIndex);
            if (current.compareTo(value) == 0) return middleIndex;
            else if (current.compareTo(value) < 0) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public static int binarySearchFirst(List<String> list, String value) {
        int startIndex = 0;
        int endIndex = list.size() - 1;

        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            String current = list.get(middleIndex);
            if (current.compareTo(value) == 0) {
                if(middleIndex == 0 || current.compareTo(list.get(middleIndex - 1)) > 0)
                    return middleIndex;
                else {
                    endIndex = middleIndex - 1;
                }
            } else if (current.compareTo(value) < 0) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public static int binarySearchLast(List<String> list, String value) {
        int startIndex = 0;
        int endIndex = list.size() - 1;

        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            String current = list.get(middleIndex);
            if (current.compareTo(value) == 0) {
                if(middleIndex == list.size() - 1 || current.compareTo(list.get(middleIndex + 1)) < 0)
                    return middleIndex;
                else {
                    startIndex = middleIndex + 1;
                }
            } else if (current.compareTo(value) < 0) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return -1;
    }
}
