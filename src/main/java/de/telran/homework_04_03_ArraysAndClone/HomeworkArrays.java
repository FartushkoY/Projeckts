package de.telran.homework_04_03_ArraysAndClone;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkArrays {
    public static void main(String[] args) {
        String[] strings = {"One", "Two", "Three"};
        System.out.println(Arrays.toString(strings));
        System.out.println("Array in reverse order: " + Arrays.toString(reverseArray(strings)));
        System.out.println("---------------------");

        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, 0, 0}};
        printMatrix(matrix);
        System.out.println("Transponse matrix:");
        printMatrix(transpose(matrix));

        System.out.println("---------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows of the array");
        int m = scanner.nextInt();
        System.out.println("Enter the number of columns of the array");
        int n = scanner.nextInt();
        printMatrix(makeDiagonal(m, n));


    }


    //    Напишите метод, который меняет местами элементы одномерного массива из String в обратном порядке.
//    public static String[] reverseArray(String[] strings) {
//        if (strings.length % 2 != 0) {
//            for (int i = 0; i < (strings.length - 1) / 2; i++) {
//                String temp = strings[i];
//                strings[i] = strings[strings.length - i - 1];
//                strings[strings.length - i - 1] = temp;
//            }
//        } else {
//            for (int i = 0; i < strings.length / 2; i++) {
//                String temp = strings[i];
//                strings[i] = strings[strings.length - i - 1];
//                strings[strings.length - i - 1] = temp;
//            }
//        }
//        return strings;
//    }


    public static String[] reverseArray(String[] strings) {
        for (int i = 0; i < strings.length / 2; i++) {
            String temp = strings[i];
            strings[i] = strings[strings.length - i - 1];
            strings[strings.length - i - 1] = temp;
        }
        return strings;
    }


//    Создать метод transpose(), который будет транспонировать матрицу (заменять строки на столбцы).


    private static int[][] transpose(int[][] matrix) {
        int[][] transposeMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
    }


    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\n");

        }
    }

// Написать метод generateMatrix(), который будет создавать матрицу размера n на m, у которой
//На главной диагонали будут единицы, остальные значения 0


    private static int[][] makeDiagonal(int m, int n) {
        int[][] arrayDiagonal = new int[m][n];
        for (int i = 0; i < Math.min(m, n); i++) {
            arrayDiagonal[i][i] = 1;
        }
        return arrayDiagonal;
    }
}
