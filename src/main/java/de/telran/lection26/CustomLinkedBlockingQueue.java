package de.telran.lection26;

import java.util.LinkedList;
import java.util.Queue;

public class CustomLinkedBlockingQueue<T> {

    private Queue<T> queue = new LinkedList<>();

    public void put(T t) {
        synchronized (queue) {
            queue.add(t);
            queue.notify();
        }
    }

    public T take() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();
        }
    }

    public int size() {
        synchronized (queue) {
            return queue.size();
        }
    }


}
