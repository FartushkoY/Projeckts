package de.telran.Algorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {5, 8, 15, 4, 1, 9, 2, 0, -7, -4};
//        System.out.println(Arrays.toString(mergeSort(array,0, array.length - 1)));
    }

//    private static int[] mergeSort(int[] array, int head, int tail) {
//        int[] sortArray = new int[array.length];
//        int middle = head + (tail - head) / 2;
//        if (head == tail){
//            return ;
//        }
//      mergeSort(array, head, middle - 1);
//      mergeSort(array, middle, tail);
//      return merge(array, head, middle, tail);
//
//    }

    private static int[] merge(int[] array, int head, int middle, int tail) {
        int[] sortArray = new int[tail - head];
        int indLeft = 0;
        int indRight = 0;

        while (head + indLeft < middle && middle + indRight <= tail) {
            if (array[head + indLeft] < array[middle + indRight]) {
                sortArray[indLeft + indRight] = array[head + indLeft];
                indLeft++;
            } else {
                sortArray[indLeft + indRight] = array[middle + indRight];
                indRight++;
            }
        }
        while (head + indLeft < middle) {
            sortArray[indLeft + indRight] = array[head + indLeft];
        }
        while (middle + indRight <= tail) {
            sortArray[indLeft + indRight] = array[middle + indRight];
        }


        return sortArray;
    }



}
