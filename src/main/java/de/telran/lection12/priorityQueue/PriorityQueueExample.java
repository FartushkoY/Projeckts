package de.telran.lection12.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        Queue<Integer> costs = new PriorityQueue<>();
        costs.add(12);
        costs.add(21);
        costs.add(2);
        costs.add(30);
        costs.add(21);

        System.out.println(costs.peek());
        System.out.println(costs);
        System.out.println(costs.poll());
        System.out.println(costs.poll());
        System.out.println(costs.poll());
        System.out.println(costs.poll());

        // max binary heap
        costs= new PriorityQueue<>(Comparator.reverseOrder());
        costs.add(12);
        costs.add(32);
        costs.add(1);
        costs.add(12);
        System.out.println(costs.poll());
        System.out.println(costs.poll());
        System.out.println(costs.poll());
        System.out.println(costs.poll());




    }
}
