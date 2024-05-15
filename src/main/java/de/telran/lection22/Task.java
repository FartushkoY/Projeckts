package de.telran.lection22;

import java.util.regex.Pattern;

public class Task {
    public static void main(String[] args) {

//  1) Напишите регулярное выражение, которое соответствует пин-коду из 4 чисел.
    System.out.println(Pattern.matches("\\d{4}", "1814"));

    // 2) Напишите регулярное выражение, которое соответствует именам клавиш F1-F12.
    System.out.println(Pattern.matches("(F[\\d^0])|(F1[0-2])", "F10"));

    // 3) Напишите регулярное выражение, которое соответствует URL-адресу сайта вида https://someaddress.someending
    System.out.println(Pattern.matches("https://[a-z]+\\.[a-z]+", "https://someaddress.someending"));
    System.out.println(Pattern.matches("https://[a-z]+\\.[a-z]+", "https:/someaddress.someending"));
    System.out.println(Pattern.matches("https://[a-z]+\\.[a-z]+", "https://someaddresssomeending"));

    }

}
