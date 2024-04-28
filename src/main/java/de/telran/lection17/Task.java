package de.telran.lection17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        // a). Получить все возможные значения сумм чисел из обоих списков
        list1.stream().flatMap(elment1 -> list2.stream().map(elment2 -> elment1 + elment2)).distinct().forEach(System.out::println);

        // b). Получить все возможные комбинации пар чисел из обоих списков [1, 4] [2, 6]
        list1.stream().flatMap(element1 -> list2.stream().map(element2 -> new int[]{element1, element2}))
                .forEach(i -> System.out.println(Arrays.toString(i)));

//        с). Найти все пары чисел, сумма которых будет равна заданному значению sum
        int sum = 7;
        Integer[][] pairsWithSum = list1.stream().flatMap(element1 -> list2.stream()
                .filter(element2 -> element1 + element2 == sum).map(element2 -> new Integer[]{element1, element2}))
                .toArray(Integer[][]::new);
        System.out.println(Arrays.deepToString(pairsWithSum));



    }
}
