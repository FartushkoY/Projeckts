package de.telran.lection11.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExamples {

    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");

        for (String s : queue) {
            System.out.println(s);
        }

        System.out.println(queue.peek());
        System.out.println(queue.element());

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
//        System.out.println(queue.remove());
        System.out.println(queue.poll());

        Deque<String> deque = new ArrayDeque<>();
        deque.add("One");
        deque.add("Two");
        deque.add("Thre");

        deque = new LinkedList<>();
        deque.addFirst("A");
        deque.addLast("B");
        deque.addFirst("C");
        deque.add("C");
        System.out.println(deque);

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
//        System.out.println(deque.removeLast());


    }
}
