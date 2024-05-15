package de.telran.summary8;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
//        int result;
        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);

        int index = random.nextInt(3);
        int correctResult;

        if (index == 1) {
            correctResult = a+b;
            System.out.println(a + " + " + b);
        } else {
            correctResult = a-b;
            System.out.println(a + " - " + b);
        }
        try(
        Scanner scanner = new Scanner(System.in);
        ) {
            System.out.println("Enter answer: ");
            int result = scanner.nextInt();
            System.out.println((result == correctResult));
        }






    }
}
