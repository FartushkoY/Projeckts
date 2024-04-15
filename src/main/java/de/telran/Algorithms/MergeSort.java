package de.telran.Algorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {5, 8, 15, 4, 1, 9, 2, 0, -7, -4};
        System.out.println(Arrays.toString(mergeSort(array)));
    }

    private static int[] mergeSort(int[] array) {
        int[] sortArray = new int[array.length];
        int head = 0;
        int tail = array.length;
        int middle = head + (tail - head) / 2;
//        getLeftArray(array);



        return sortArray;
    }

//    private static int[] getLeftArray(int[] array) {
//        int head = 0;
//        int tail = array.length - 1;
//        int middle = head - (head - tail) / 2;
//        if (head + 1 == tail) {
//            int[] arrayLeft = Arrays.copyOfRange(array, head, middle);
//            return arrayLeft;
//        }
//       return getLeftArray();
//    }

//    private static int[] getLRightArray(int[] array, int head, int tail) {
//
//        int middle = head - (head - tail) / 2 + 1;
//        if (head + 1 == tail) {
//            int[] arrayLeft = Arrays.copyOfRange(array, head, middle);
//            return arrayLeft;
//        }
//        return getLeftArray(array, head, middle);
//    }


}
