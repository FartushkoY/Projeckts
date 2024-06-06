package de.telran.Algorithms.lesson_04_06;

import java.util.Arrays;

public class MerdgeSort {

    public static int[] myMerdgeSort(int[] array) {
        int tmp = array[0];

        for (int i = array.length; i >= 0; i--) {
            for (int j = 1; j < i; j++) {
                if (array[j - 1] > array[j]) {
                    tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;

//        for (int i = array.length - 1; i >= 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if (array[j-1] > tmp) {
//                    tmp = array[j];
//                    array[j-1] = array[j];
//                }
//            }
//        } return array;


    }


    public static void main(String[] args) {
        int[] array = {2, 4, 8, 1, 3, 7, 10, 9, 0, 5};
        System.out.println(Arrays.toString(myMerdgeSort(array)));

    }

}
