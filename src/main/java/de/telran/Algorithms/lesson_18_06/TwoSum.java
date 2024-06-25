package de.telran.Algorithms.lesson_18_06;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(getTwoSum(arr, target)));
        System.out.println(Arrays.toString(getTwoSum(new int[]{2,3,4}, 6)));
        System.out.println(Arrays.toString(getTwoSum(new int[]{-1, 0}, -1)));

    }

    private static int[] getTwoSum(int[] arr, int target) {
        int[] indexArr = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    indexArr[0] = i + 1;
                    indexArr[1] = j + 1;
                }
            }
        }
        return indexArr;
    }


}
//    В массиве целых чисел с индексом 1, который уже отсортирован в неубывающем порядке,
//    найдите два числа, которые в сумме дают определенное целевое число.
//    Пусть эти два числа будут numbers[index1] и numbers[index2], где 1 <= index1 < index2 <= numbers.length.
//    Верните индексы двух чисел, index1 и index2, сложенных по одному,
//    в виде целочисленного массива [index1, index2] длины 2.
//    Тесты генерируются таким образом, что существует ровно одно решение.
//    Вы не можете использовать один и тот же элемент дважды.
//    Ваше решение должно использовать только постоянное дополнительное пространство.
