package de.telran.lection16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        IntStream intStream1 = IntStream.of(1, 1, 7, 2);
        int sum = IntStream.rangeClosed(1, 100).sum();
        System.out.println(sum);


        IntStream.rangeClosed(1, 100).filter(value -> value %3 == 0 && value %5 == 0).forEach(System.out::println);

        Integer[] data = new Integer[10];

        IntStream.range(0, 10).forEach(i -> data[i] = i);
        System.out.println(Arrays.toString(data));

        IntStream.range(0, 10).map(i -> i * i).forEach(System.out::println);
        
        Stream<Integer> boxed = IntStream.range(0, 10).boxed();
        IntStream intStream = boxed.mapToInt(value -> value);

        List<String[]> list = IntStream.range(0, 10).mapToObj(value -> new String[value]).toList();
        list.forEach(strings -> System.out.println(Arrays.toString(strings)));

    }
}
