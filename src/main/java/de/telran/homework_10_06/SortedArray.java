package de.telran.homework_10_06;

import java.util.Arrays;
import java.util.Random;

public class SortedArray {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < 100_000; i++) {
            array[i] = random.nextInt(100000);
        }

        long start;
        long end;

        start = System.currentTimeMillis();
        int[] array1 = Arrays.stream(array).sorted().toArray();
        end = System.currentTimeMillis();
        System.out.println("Sorting time sequential: " + (end - start));

        start = System.currentTimeMillis();
        int[] array3 = Arrays.stream(array).sorted().toArray();
        end = System.currentTimeMillis();
        System.out.println("Sorting time sequential: " + (end - start));

        start = System.currentTimeMillis();
        int[] array4 = Arrays.stream(array).sorted().toArray();
        end = System.currentTimeMillis();
        System.out.println("Sorting time sequential: " + (end - start));

        start = System.currentTimeMillis();
        int[] array5 = Arrays.stream(array).parallel().sorted().toArray();
        end = System.currentTimeMillis();
        System.out.println("Sorting time parallel: " + (end - start));

        start = System.currentTimeMillis();
        int[] array6 = Arrays.stream(array).parallel().sorted().toArray();
        end = System.currentTimeMillis();
        System.out.println("Sorting time parallel: " + (end - start));

        start = System.currentTimeMillis();
        int[] array7 = Arrays.stream(array).parallel().sorted().toArray();
        end = System.currentTimeMillis();
        System.out.println("Sorting time parallel: " + (end - start));



    }
}
