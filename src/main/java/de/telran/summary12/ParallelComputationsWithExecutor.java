package de.telran.summary12;

import java.util.List;
import java.util.concurrent.*;

public class ParallelComputationsWithExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Thread1 2 ---- 33_000
        //Thread2 33_000 ---- 66_000
        //Thread3 66_000 ---- 100_000
        Task task1 = new Task(2, 60000);
        Task task2 = new Task(60000, 80000);
        Task task3 = new Task(80000, 100000);
        List<Task> tasks = List.of(task1, task2, task3);
        ExecutorService executor = Executors.newCachedThreadPool();

        List<Future<Integer>> futures = executor.invokeAll(tasks);

        int sum = futures.stream().mapToInt(f -> {
            try {
                return f.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).sum();
        System.out.println(sum);
        executor.shutdown();
    }

    static  class Task implements Callable<Integer> {
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int primeCount = 0;
            for (int i = start; i < end; i++) {
                boolean isPrime = true;
                for
                (int j=2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime)
                    primeCount++;
            }
            return primeCount;
        }
    }
}
