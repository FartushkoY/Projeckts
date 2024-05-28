package de.telran.Algorithms.lesson05_28;

public class MaxGap {

// написать функцию, которая получает на вход отсортированный массив целых чисел
// и возвращает максимальную разницу между соседними значениями.
// Например:
//
// Input: [2, 6, 7, 11, 14]
// Output: 4 (11-7)
//
// Сначала сделать нерекурсивную версию maxGapIter, затем - рекурсивную maxGapRecursive


    public static int maxGapIter(int[] input) {
        int result = 0;
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i + 1] - input[i] > result) {
                result = input[i + 1] - input[i];
            }
        }
        return result;
    }


    public static int maxGapRecursive(int[] input) {

        return Recursive(input, 0);

//        public static int maxGapFrom(int[] input, int from) {
//            if (from >= input.length - 1) {
//                return 0;
//            } else {
//                int curGap = input[from+1] - input[from];
//                int otherGap = 0; // на остатке массива
//            }

    }

    public static int Recursive(int[] input, int ind) {
        int gap;
        if (ind >= input.length - 1) return 0;
        else {
            int gap1 = input[ind + 1] - input[ind];
            gap = Math.max(gap1, Recursive(input, ind + 1));
        }
        return gap;
    }

    private static int maxGapFrom(int[] input, int i) { // Маша
        if(i >= input.length -1){
            return 0;

        }else {
            int curGap = input[i+1] - input[i];
            int otherGap = maxGapFrom(input, i+1);
            if(curGap>otherGap){
                return curGap;

            }else {
                return otherGap;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(maxGapIter(new int[]{2, 6, 7, 11, 14}));
        System.out.println(maxGapRecursive(new int[]{2, 6, 7, 11, 14}));
    }


}
