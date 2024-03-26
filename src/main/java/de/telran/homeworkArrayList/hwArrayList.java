package de.telran.homeworkArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class hwArrayList {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("I'm", "learning", "java", "and", "I'm", "gonna", "be", "a", "cool", "developer");
//        1. У вас есть список значений String, вы должны вернуть список количества символов этих String
        System.out.println(getListNumOfLetters(strings));

//       2. у вас есть список значений String, вы должны вернуть список со всеми значениями String более трех символов?
        System.out.println(getThreeLetterWords(strings));

//        3. у вас есть список значений Integer, вы должны вернуть их сумму
        List<Integer> listInt = Arrays.asList(3, 10, 4, 5, 90, 6, 7, 33);
        List<Integer> listInt1 = Arrays.asList(3, 4, 5, 6, 7, 10, 33, 90);
        System.out.println(getSum(listInt));

//        4. у вас есть список значений Integer, вы должны вернуть их максимум
        System.out.println(getMax(listInt));

//        5. у вас есть список String, вы должны вернуть максимальную длину String
        System.out.println(getMaxLength(strings));

//        6. Написать метод, который проверяет, является ли список Integer отсортированным.
        System.out.println(isSort(listInt));
        System.out.println(isSort(listInt1));

//        7. Написать метод, который выдает из исходного списка список всех значений, делящихся на заданное число q.
        System.out.println(getListOfMultiples(listInt, 3));


    }


    private static List<Integer> getListOfMultiples(List<Integer> listInt, Integer q) {
        List<Integer> listOfMultiples = new ArrayList<>();
        for (Integer i : listInt) {
            if (i % q == 0) {
                listOfMultiples.add(i);
            }
        }
        return listOfMultiples;
    }


    private static boolean isSort(List<Integer> listInt) {
        for (int i = 0; i < listInt.size() - 1; i++) {
            if(listInt.get(i) >= listInt.get(i + 1)){
                return false;
            }
        }
        return true;
    }


    private static int getMaxLength(List<String> strings) {
        int maxLength = strings.get(0).length();
        for (int i = 1; i < strings.size(); i++) {
            if (strings.get(i).length() > maxLength) {
                maxLength = strings.get(i).length();
            }
        }
        return maxLength;
    }


    private static Integer getMax(List<Integer> listInt) {
        Integer max = listInt.get(0);
        for (Integer i : listInt) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }


    private static Integer getSum(List<Integer> listInt) {
        Integer sum = 0;
        for (Integer i : listInt) {
            sum += i;
        }
        return sum;
    }


    private static List<Integer> getListNumOfLetters(List<String> strings) {
        List<Integer> listNumOfLetters = new ArrayList<>();
        for (String s : strings) {
            listNumOfLetters.add(s.length());
        }
        return listNumOfLetters;
    }


    private static List<String> getThreeLetterWords(List<String> strings) {
        List<String> result = new ArrayList<>();
        for (String s : strings) {
            if (s.length() > 3) {
                result.add(s);
            }
        }
        return result;
    }
}

