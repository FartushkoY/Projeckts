package de.telran.homework_17_05_Tests;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task {
    public static void main(String[] args) {
//        1. Разбить текст на список отдельных строк этого текста.

        String text = "one cat hello world\n" +
                "oneA login: admin password: sKb122 cat login: admin two three\n" +
                "login: user password: sKb322 five\n" +
                "world  one hello";

        List<String> strings = new ArrayList<>();
        Pattern pattern = Pattern.compile("(.+)\\n*");
        Matcher matcher = pattern.matcher(text);
        matcher.results().forEach(s -> strings.add(s.group(1)));
//        System.out.println(strings);


        String[] split = text.split("\\n");
        System.out.println(Arrays.toString(split));

//        2. Имеется текст с логинами и паролями.
//        Найти в тексте выражения вида "login: admin", "password: sKb122", составить из них Map<login, password>

        pattern = Pattern.compile("login:\\s([a-zA-Z]+)\\spassword:\\s([\\w]+)");
        Map<String, String> collect = pattern.matcher(text).results()
                .collect(Collectors.toMap(s -> s.group(1), s -> s.group(2)));
        System.out.println(collect);

//        3. Напишите программу на Java и тест для нее для поиска общих элементов между двумя массивами целых чисел
//        example input:
//        Array1: [1, 2, 5, 5, 8, 9, 7, 10]
//        Array2: [1, 0, 6, 15, 6, 4, 7, 0]
//        example expected:
//        [1,7]

        int[] arr1 = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] arr2 = {1, 0, 6, 15, 6, 4, 7, 0};


        System.out.println(Arrays.toString(getCoincidence(arr1, arr2)));
        System.out.println(Arrays.toString(getCoincidenceStream(arr1, arr2)));


        //  4. Напишите программу на Java и тест для нее для удаления повторяющихся элементов из массива.
        //  example input:
        //  [0,3,-2,4,3,2]
        //  example expected:
        //  [0,3,-2,4,2]

        int[] arr3 = new int[]{0,3,-2,4,3,2};
        System.out.println(Arrays.toString(getUniqueArray(arr3)));


    }


    public static int[] getUniqueArray(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }


    public static int[] getCoincidence(int[] arr1, int[] arr2) {
//        int[] result = new int[Math.min(arr1.length, arr2.length)];
//        int counter = 0;
//        Set<Integer> set = new HashSet<>();
//        set.addAll(arr1);
//        result = Arrays.copyOf(result, counter);
//        return result;

        int[] result = new int[Math.min(arr1.length, arr2.length)];
        int counter = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    result[counter] = arr1[i];
                    counter++;
                }
            }
        }
        result = Arrays.copyOf(result, counter);
        return result;
    }


    public static int[] getCoincidenceStream(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1).flatMap(i -> Arrays.stream(arr2).filter(i1 -> i1 == i)).toArray();
    }
}