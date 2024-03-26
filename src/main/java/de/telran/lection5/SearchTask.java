package de.telran.lection5;

import java.util.Arrays;

public class SearchTask {

    public static void main(String[] args) {
        String[] data = {"A", "D", "B", "F"};

//        isPresent(data, "B");
        System.out.println(findIndex(data, "B"));

        int[] sortedData = {2, 4, 6, 9, 10};
        System.out.println(findIndexBinarySearch(sortedData, 9));
        System.out.println(Arrays.binarySearch(sortedData, 9));


    }

    private static int findIndexBinarySearch(int[] sortedData, int i) {
        // TODO

        return 0;
    }

    public static int findIndex(String[] data, String element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
}
