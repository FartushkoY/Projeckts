package de.telran.practice_lesson_29;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
//        Scanner scanner  = new Scanner(System.in);


//        System.out.println("Hallo World!");

        if (args.length > 0) {
            System.out.println(args[1]);
        } else System.out.println("Hallo World!");


    }

}
