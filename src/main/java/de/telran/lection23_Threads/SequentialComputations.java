package de.telran.lection23_Threads;

public class SequentialComputations {

    public static void main(String[] args) {
//        int k = 0;
//        int l = 0;
//        k++;
//        l++;
//        someMethod1(k);
//        someMethod2(l);

        //count prime numbers
        long start = System.currentTimeMillis();
        int count = 0;
        for (int i = 2; i < 100_000; i++) {
            boolean isPrime = true;
            for
            (int j=2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                count++;
        }
        long end = System.currentTimeMillis();
        System.out.println("Total numbers of prime: " + count);
        System.out.println("Time elapsed: " + (end - start) + ", ms");
    }

    private static void someMethod2(int j) {
        System.out.println(j);
    }

    private static void someMethod1(int i) {
        System.out.println(i);
    }
}
