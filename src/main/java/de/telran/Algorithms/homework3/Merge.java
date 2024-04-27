package de.telran.Algorithms.homework3;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr1 = {2,4,7,11};
        int[] arr2 = {1,3,4,5,8,12};
        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] sortArr = new int[arr1.length + arr2.length];
        int indArr1 = 0;
        int indArr2 = 0;
        while (indArr1 < arr1.length && indArr2 < arr2.length) {
            if (arr1[indArr1] < arr2[indArr2]) {
                sortArr[indArr1 + indArr2] = arr1[indArr1];
                indArr1++;
            } else {
                sortArr[indArr1 + indArr2] = arr2[indArr2];
                indArr2++;
            }
        }
        while ((indArr1 < arr1.length)) {
            sortArr[indArr1 + indArr2] = arr1[indArr1];
            indArr1++;
        }
        while ((indArr2 < arr2.length)) {
            sortArr[indArr1 + indArr2] = arr2[indArr2];
            indArr2++;
        }
        return sortArr;
    }
}
