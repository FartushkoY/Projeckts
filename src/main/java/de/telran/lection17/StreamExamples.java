package de.telran.lection17;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {
        double sum = 0.0;
        for (int i = 0; i < 10_000; i++) {
            sum += 0.1;
        }
        System.out.println(sum);

        System.out.println(IntStream.range(0, 10_000).mapToDouble(i -> 0.1).sum());

        List<Integer> distinctSorted = Stream.of(2, 4, 1, 0, 0, 2)
                .peek(e -> System.out.println("stream: " + e))
                .distinct()
                .peek(e -> System.out.println("distinct: " + e))
                .sorted()
                .peek(e -> System.out.println("sorted: " + e))
                .toList();
        System.out.println(distinctSorted);

        distinctSorted = Stream.of(2, 4, 1, 0, 0, 2)
                .peek(e -> System.out.println("stream: " + e))
                .sorted()
                .peek(e -> System.out.println("sorted: " + e))
                .distinct()
                .peek(e -> System.out.println("distinct: " + e))
                .toList();
        System.out.println(distinctSorted);
    }


    public static List<String> method(List<String> strings) { // O(n^2)
        List<String> result = new ArrayList<>();
        for (String s : strings) {
            if (!result.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static List<String> methodWithStream(List<String> strings) { // O(n)
        return strings.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    public static void fill(List<Integer> list, int capacity) {
        for (int i = 0; i < capacity; i++) {
            list.add(i);
        }
    }

    public static void fillWithStream(List<Integer> list, int capacity) {
        IntStream.range(0, capacity).forEach(list::add);
    }

}


