package de.telran.Algorithms;

import java.util.Arrays;

public class Lesson_18_06 {
    public static void main(String[] args) {


        int[] arr = {-5, -2, -1, 3, 7, 10};

//        int startIndex = 0;
//        int minAbs = Math.abs(arr[0]);
//        for (int i = 0; i < arr.length; i++) {
//            if (Math.abs(arr[i]) < minAbs) {
//                minAbs = Math.abs(arr[i]);
//                startIndex = i;
//            }
//        }
//        arrRes[0] = arr[startIndex] * arr[startIndex];
//        int indexRes = 1;
//
//
//        int left = startIndex - 1;
//        int right = startIndex + 1;
//            while (left >= 0 && right <= arr.length) {
//                if (Math.abs(arr[left]) <= Math.abs(arr[right])) {
//                    arrRes[indexRes] = arr[left] * arr[left];
//                    indexRes++;
//                    left--;
//                } else {
//                    arrRes[indexRes] = arr[right] * arr[right];
//                    indexRes++;
//                    right++;
//                }
//            }
//            while (left >= 0) {
//                arrRes[indexRes] = arr[left] * arr[left];
//                indexRes++;
//                left--;
//            }
//            while (right < arr.length) {
//                arrRes[indexRes] = arr[right] * arr[right];
//                indexRes++;
//                right++;
//            }

        int[] arrRes = Arrays.stream(arr).map(i -> i * i).sorted().toArray();

        System.out.println(Arrays.toString(arrRes));
    }







}

