package de.telran.Algorithms.lesson_25_06;
// Задача 1
// Восстановить все возможные IP адреса по строке цифр, если это возможно
// IP адрес - это строка, содержащая 4 числа 0 <= N <= 255, разделённых точками
//
// Примеры:
//
// Input: "25525511135"
// Output: ["255.255.11.135","255.255.111.35"]
//
// Input: "101023"
// Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson_25_06 {
    public static void main(String[] args) {

        System.out.println(recoverIps("25525511135"));
        System.out.println(recoverIps("101023"));
    }

    public static List<String> recoverIps(String s) {
        return recursIP(s, 4);
    }

    private static List<String> recursIP(String tail, int part) {
        List<String> ipList = new ArrayList<>();
        if (part == 1 && isCorrect(tail)) {
            ipList.add(tail);
        } else if (part == 0 || tail.isEmpty()) {
            return ipList;
        } else {
            for (int i = 1; i <= 3; i++) {
                if (tail.length() >= i) {
                    String s1 = tail.substring(0, i);
                    if (isCorrect(s1)) {
                        List<String> result = recursIP(tail.substring(i), part - 1);
                        for (String s : result) {
                            ipList.add(s1 + "." + s);
                        }
                    }
                }
            }
        }
        return ipList;
    }

    public static boolean isCorrect(String s) {
        if (s.isEmpty() || s.length() > 3 || s.length() > 1 && s.startsWith("0")) {
            return false;
        }
        int num = Integer.parseInt(s);
        return num <= 255;
    }
}


