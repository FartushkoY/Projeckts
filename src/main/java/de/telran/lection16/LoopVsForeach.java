package de.telran.lection16;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LoopVsForeach {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);

        for (Integer i : integers) {
            int j = i * 10;
            System.out.println(j);
        }

        integers.forEach(element -> {
            int j = element * 10;
            System.out.println(j);
        });

        integers.forEach(System.out::println);

        Set<String> set = new TreeSet<>();
//        set.forEach();




    }
}
