package de.telran.lection26;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockLinkedBlockingQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void put(T t) {
        synchronized (queue) {
            queue.add(t);
            queue.notify();
        }
    }

    public T take() {

            while (queue.isEmpty()) {
                try {
                    queue.wait();
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();

    }

    public int size() {
        synchronized (queue) {
            return queue.size();
        }
    }
}
