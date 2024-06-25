package de.telran.Algorithms.lesson_18_06;

import java.util.Arrays;

public class SortedSquares {
    public static void main(String[] args) {
        int[] arr = {-5, -2, -1, 3, 7, 10};
        System.out.println(Arrays.toString(sortedSquares(arr)));

    }

    public static int[] sortedSquares(int[] nums) {

        int[] arrRes = new int[nums.length];
        int indexMinAbs = getTurningPoint(nums);
        return getsortedSquares(nums, indexMinAbs);
    }

    private static int[] getsortedSquares(int[] nums, int indexMinAbs) {
        int[] arrRes = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = arrRes.length - 1;

        while (left <= indexMinAbs && right > indexMinAbs) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                arrRes[index] = nums[left] * nums[left];
                left++;
                index--;

            } else {
                arrRes[index] = nums[right] * nums[right];
                right--;
                index--;
            }
        }
        while (left <= indexMinAbs) {
            arrRes[index] = nums[left] * nums[left];
            index--;
            left++;
        }
        while (right > indexMinAbs) {
            arrRes[index] = nums[right] * nums[right];
            index--;
            right--;
        }
        return arrRes;
    }

    private static int getTurningPoint(int[] arr) {
        int minAbs = Math.abs(arr[0]);
        int indexMinAbs = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) < minAbs) {
                minAbs = Math.abs(arr[i]);
                indexMinAbs = i;
            }
        }
        return indexMinAbs;
    }


}

