package de.telran.Algorithms.homework3;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 7, 11};
        int[] arr2 = {1, 3, 4, 5, 8, 12};
        System.out.println(Arrays.toString(merge(arr1, arr2)));

        int[] arr3 = {2, 4, 7, 11};
        int[] arr4 = {8, 12};
        System.out.println(Arrays.toString(merge(arr3, arr4)));

        int[] arr5 = {2, 4, 7, 11};
        int[] arr6 = {8, 12};
        int[] arr7 = {4, 9, 11};
        System.out.println(Arrays.toString(mergeThree(arr5, arr6, arr7)));

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


    private static int[] mergeThree(int[] arr1, int[] arr2, int[] arr3) {
        int[] sortArr = new int[arr1.length + arr2.length + arr3.length];
        int indArr1 = 0;
        int indArr2 = 0;
        int indArr3 = 0;
        while (indArr1 < arr1.length && indArr2 < arr2.length && indArr3 < arr3.length) {
            int min = findMin(arr1[indArr1], arr2[indArr2], arr3[indArr3]);
            if (arr1[indArr1] == min) {
                sortArr[indArr1 + indArr2 + indArr3] = arr1[indArr1++];

            } else if (arr2[indArr2] == min) {
                sortArr[indArr1 + indArr2 + indArr3] = arr2[indArr2++];

            } else if (arr3[indArr3] == min) {
                sortArr[indArr1 + indArr2 + indArr3] = arr3[indArr3++];
            }
        }
        while (indArr1 < arr1.length && indArr2 < arr2.length) {
            if (arr1[indArr1] < arr2[indArr2]) {
                sortArr[indArr1 + indArr2 + indArr3] = arr1[indArr1++];
            } else {
                sortArr[indArr1 + indArr2 + indArr3] = arr2[indArr2++];
            }
        }
        while (indArr1 < arr1.length && indArr3 < arr3.length) {
            if (arr1[indArr1] < arr3[indArr3]) {
                sortArr[indArr1 + indArr2 + indArr3] = arr1[indArr1++];
            } else {
                sortArr[indArr1 + indArr2 + indArr3] = arr3[indArr3++];
            }
        }
        while (indArr2 < arr2.length && indArr3 < arr3.length) {
            if (arr2[indArr2] < arr3[indArr3]) {
                sortArr[indArr1 + indArr2 + indArr3] = arr2[indArr2++];
            } else {
                sortArr[indArr1 + indArr2 + indArr3] = arr3[indArr3++];
            }
        }
        while (indArr1 < arr1.length) {
            sortArr[indArr1 + indArr2 + indArr3] = arr1[indArr1++];
        }
        while (indArr2 < arr2.length) {
            sortArr[indArr1 + indArr2 + indArr3] = arr2[indArr2++];
        }
        while (indArr3 < arr3.length) {
            sortArr[indArr1 + indArr2 + indArr3] = arr3[indArr3++];
        }
        return sortArr;
    }

    private static int findMin(int m, int n, int k) {
        int min = m;
        if (n <= m && n <= k) min = n;
        if (k <= m && k <= n) min = k;
        return min;
    }
}
