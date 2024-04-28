package de.telran.Algorithms;

public class Lesson03_26 {
    public static boolean isEven(int n) {
        if (n == 0) {
            return true;
        } else {
            return !isEven(n - 1);
        }
    }



    public static void main(String[] args) {
        System.out.println(isEven(3));
    }
}
