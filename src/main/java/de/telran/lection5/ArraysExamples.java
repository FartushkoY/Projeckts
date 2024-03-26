package de.telran.lection5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraysExamples {

    public static void main(String[] args) {

//        int[] ints1 = new int[10];
//        int ints2[] = new int[10];
//        int[] ints3 = {1, 2, 3};
//        int[] ints4 = new int[]{1, 2, 3};
//        var ints5 = new int[10];
//        var ints6 = new int[]{1, 2, 3};
//
//        System.out.println(ints1.getClass().getSimpleName());
//        System.out.println(Arrays.toString(ints4));
//
//        for (int i = 0; i < ints6.length; i++) {
//            System.out.println(ints6[i]);
//        }
//
//        for (int value : ints6) {
//            System.out.println(value);
//        }
//
//        String[][] strings = new String[3][];
//        strings[0] = new String[]{"A", "B"};
//        strings[1] = new String[]{"C", "D", "E", "F"};
//        strings[2] = new String[]{"G", "H", "I"};
//
//        for (int i = 0; i < strings.length; i++) {
//            System.out.println("Retieving data from i = " + i);
//            for (int j = 0; j < strings[i].length; j++) {
//                System.out.println(strings[i][j]);
//
//            }
//
//        }


        int[][] ints2DArray = new int[5][7];
        print20Array(ints2DArray);
        System.out.println("---------------------------");

        ints2DArray[3][6] = 8;
        print20Array(ints2DArray);

        String[] data = {"Hello", "World", "!!!", "Cat", "cat", "+++"};
        System.out.println(Arrays.toString(data));

        System.out.println(Arrays.deepToString(ints2DArray));

        int[] dataArray = {2, 6, 1, 0};
        int[] copied = Arrays.copyOf(dataArray, 2);
        System.out.println(Arrays.toString(copied));

        String[] newArray = new String[5];
        Arrays.fill(newArray, "Value");
        System.out.println(Arrays.toString(newArray));

        Arrays.sort(dataArray);  //quick sort alg
        System.out.println(Arrays.toString(dataArray));

        Arrays.sort(data);   // merge sort alg
        System.out.println(Arrays.toString(data));

    }

    private static void print20Array(int[][] ints2DArray) {
        for (int i = 0; i < ints2DArray.length; i++) {
        for (int j = 0; j < ints2DArray[0].length; j++) {
            System.out.print(ints2DArray[i][j] + " ");
        }
        System.out.println("\n");

    }
    }
}
