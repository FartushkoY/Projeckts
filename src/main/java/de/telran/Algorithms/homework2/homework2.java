package de.telran.Algorithms.homework2;

import java.util.Arrays;
import java.util.Collections;

public class homework2 {
    public static void main(String[] args) {

        int[] arr1 = {11, 22, 44, 50, 60, 86, 114, 140, 145, 190};
        int[] arr2 = {1, 24, 30, 46, 60, 100, 120, 133, 270};
        System.out.println(findElement(arr1, 114));
        System.out.println(findElement(arr2, 114));

        int[] arr3 = {4, 7, 9, 2, 15, 14};
        System.out.println(getResultTask2(arr3));

        Integer[] coins1 = {3, 2, 10, 2, 3};
        System.out.println(getResultTask3(coins1, 16));
    }


    public static int findElement(int[] arr, int x) {
        return serchElem(arr, x, 0, arr.length - 1);
    }
    public static int serchElem(int[] arr, int x, int indexStart, int indexEnd) {
        int indexMiddle = indexStart + (indexEnd - indexStart) / 2;
        if (indexEnd < indexStart) {
            return -1;
        }
        if (arr[indexMiddle] == x) {
            return indexMiddle;
        } else if (arr[indexMiddle] < x) {
            indexStart = indexMiddle + 1;
            return serchElem(arr, x, indexStart, indexEnd);
        } else {
            indexEnd = indexMiddle - 1;
            return serchElem(arr, x, indexStart, indexEnd);
        }
    }

    private static int getResultTask2(int[] arr) {
        return findMax(arr, 1, arr[0]);
    }
    private static int findMax(int[] arr, int i, int max) {
        if (i == arr.length) {
            return max;
        }
        if (arr[i] > max) {
            max = arr[i];
        }
        i++;
        return findMax(arr, i, max);
    }
    //    В итоге это же хвостовая рекурсия получилась?








    private static boolean canPay(Integer[] coins, int i, int x) {
        if (i == coins.length) return false;
        if (x - coins[i] == 0) {
            return true;
        }
        if (x - coins[i] > 0) {
            x = x - coins[i];
        }
        i++;
        return canPay(coins, i, x);
    }


    private static boolean getResultTask3(Integer[] coins, int x) {
        Arrays.sort(coins, Collections.reverseOrder());
        return canPay(coins, 0, x);
    }
//    здесь без сортировки я не нашла вариант решения,
//    т к нужно же сначала монеты большего номинала использовать, а пртом уже добирать меньшими
}