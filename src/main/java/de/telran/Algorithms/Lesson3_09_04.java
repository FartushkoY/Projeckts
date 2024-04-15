package de.telran.Algorithms;

import java.util.Arrays;

public class Lesson3_09_04 {

    public class MergeSort {

        public static void merge(
                int[] a, int[] l, int[] r, int left, int right) {

            int i = 0, j = 0, k = 0;
            while (i < left && j < right) {
                if (l[i] <= r[j]) {
                    a[k++] = l[i++];
                } else {
                    a[k++] = r[j++];
                }
            }
            while (i < left) {
                a[k++] = l[i++];
            }
            while (j < right) {
                a[k++] = r[j++];
            }
        }

        public static void mergeSort(int[] a, int n) {
            if (n < 2) {
                return;
            }
            int mid = n / 2;
            int[] l = new int[mid];
            int[] r = new int[n - mid];

            for (int i = 0; i < mid; i++) {
                l[i] = a[i];
            }
            for (int i = mid; i < n; i++) {
                r[i - mid] = a[i];
            }
            mergeSort(l, mid);
            mergeSort(r, n - mid);

            merge(a, l, r, mid, n - mid);
        }
    }

    public class QuickSort {

        public static void quickSort(int arr[], int begin, int end) {
            if (begin < end) {
                int partitionIndex = partition(arr, begin, end);

                quickSort(arr, begin, partitionIndex - 1);
                quickSort(arr, partitionIndex + 1, end);
            }
        }

        private static int partition(int arr[], int begin, int end) {
            int pivot = arr[end];
            int i = (begin - 1);

            for (int j = begin; j < end; j++) {
                if (arr[j] <= pivot) {
                    i++;

                    int swapTemp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swapTemp;
                }
            }

            int swapTemp = arr[i + 1];
            arr[i + 1] = arr[end];
            arr[end] = swapTemp;

            return i + 1;
        }


    }


    public static void main(String[] args) {
        int[] arr = {5, 1, 6, 19, 2, 3, 4};

        MergeSort.mergeSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));

        QuickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

}
