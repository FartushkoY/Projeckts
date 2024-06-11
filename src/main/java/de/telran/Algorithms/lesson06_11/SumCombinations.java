package de.telran.Algorithms.lesson06_11;

import java.util.ArrayList;
import java.util.List;

public class SumCombinations {
    // Задача 2
//
// Вывести все способы, которыми мужно набрать сумму из набора монет нужного достоинства
//
// Примеры:
// Input: [2,3,5], 7
// Output:
// 2,2,3
// 2,5


    public static void genCombinations(int[] values, int sum) {


        recursionGenCombinations(values, sum, new ArrayList<>());

    }

    private static void recursionGenCombinations(int[] values, int sum, ArrayList<Integer> results) {
        if (sum == 0) {
            System.out.println(results);

        } else {
            for (int i = 0; i < values.length; i++) {
                int res = sum - values[i];
                if (res >= 0) {
                    ArrayList<Integer> resultsCopy = new ArrayList<>(results);
                    resultsCopy.add(values[i]);
                    recursionGenCombinations(values, res, resultsCopy);
                }
            }

        }

    }


    public static void main(String[] args) {

        int[] coins = {2, 3, 5};
        genCombinations(coins, 7);
    }

}

