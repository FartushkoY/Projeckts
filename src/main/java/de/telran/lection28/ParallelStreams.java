package de.telran.lection28;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ParallelStreams {

    public static void main(String[] args) {
        long start;
        long sum;
        long end;

        start = System.currentTimeMillis();
        sum = LongStream.rangeClosed(1, 100_000-000).parallel().sum();
        end = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println("Time ellapsed parallel: " + (end - start));


        start = System.currentTimeMillis();
        sum = LongStream.rangeClosed(1, 100_000-000).sum();
        end = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println("Time ellapsed sequentially: " + (end - start));






    }
}
