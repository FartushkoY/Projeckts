package de.telran.summary6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer redused = list.stream().reduce(0, Integer::sum);
        redused = list.stream().reduce(Integer::sum).orElse(-1);


        // 1. a^2 + b^2 + c^2
        Integer reduce1 = list.stream().reduce(0, (acc, element) -> acc + element * element);
        System.out.println(reduce1);

        // 2. Дан список слов "Specific" "Measurable" "Achievable" "Relevant" "Time-bound".
        // С помощью стримов вывести его аббревиатуру в виде S.M.A.R.T
        // map() ---> reduce()
        List<String> strings = Arrays.asList("Specific", "Measurable", "Achievable", "Relevant", "Time-bound");
        String smart = strings.stream().map(s -> s.substring(0, 1)).reduce((s1, s2) -> s1 + "." + s2).get();
        System.out.println(smart);

        // max()
        Integer max = list.stream().reduce(Math::max).get();
        System.out.println(max);


    }
}
