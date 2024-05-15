package de.telran.lection21;

import java.time.Duration;
import java.time.Instant;

public class MeasureTime {

    public static void main(String[] args) {
        // 1 option to measure time
        Instant start = Instant.now();
        int result = fibonacciSequence(45);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration);
        System.out.println("Time: " + duration.getSeconds() + "s, " + duration.getNano() + " ns");
        System.out.println("Result: " + result);

        // 2 option to measure time
        long startTime = System.currentTimeMillis();
        result = fibonacciSequence(45);
        long endTime = System.currentTimeMillis();
        System.out.println("Time of fibonacciSequence() work: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        result = fibonacciSequence(45);
        endTime = System.currentTimeMillis();
        System.out.println("Time of fibonacciSequence() work: " + (endTime - startTime) + " ms");

        // 3 option to measure time
        long nanoTime = System.nanoTime();

    }

    // 0 1 1 2 3 5 8 13 21 ...
    public static int fibonacciSequence(int n) { // O(2^n) ----> can be O(n)
        if (n == 0) return 0; // base condition
        if (n == 1) return 1; // base condition
        return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);
    }

}
