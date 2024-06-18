package de.telran.homework_03_06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockArrayDeque<T> {

    private final Deque<T> deque;
    private final int capacity;
//    private int counter;
    private final ReentrantLock lock = new ReentrantLock(true);

    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public ReentrantLockArrayDeque(int capacity) {
        this.capacity = capacity;
        this.deque = new ArrayDeque<T>(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public void putFirst(T t) {
        lock.lock();
        try {
            while (deque.size() == capacity) {
                notFull.awaitUninterruptibly();
            }
            deque.addFirst(t);
//            counter++;
            System.out.println(Thread.currentThread().getName() + " putFirst " + t + ", deque.size; " + deque.size());
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public void putLast(T t) {
        lock.lock();
        try {
            while (deque.size() == capacity) {
                notFull.awaitUninterruptibly();
            }
            deque.addLast(t);
//            counter++;
            System.out.println(Thread.currentThread().getName() + " putLast " + t + ", deque.size; " + deque.size());
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }


    public T takeFirst() {
        lock.lock();
        try {
            while (deque.isEmpty()) {
                notEmpty.awaitUninterruptibly();
            }
//            counter--;
            System.out.println(Thread.currentThread().getName() + " takeFirst " + deque.peekFirst() + ", deque.size; " + deque.size());
            notFull.signal();
            return deque.removeFirst();

        } finally {
            lock.unlock();
        }
    }

    public T takeLast() {
        lock.lock();
        try {
            while (deque.isEmpty()) {
                notEmpty.awaitUninterruptibly();
            }
//            counter--;
            System.out.println(Thread.currentThread().getName() + " takeLast " + deque.peekLast() + ", deque.size; " + deque.size());
            notFull.signal();
            return deque.removeLast();

        } finally {
            lock.unlock();
        }
    }


    public int size() {
        lock.lock();
        try {
            return deque.size();
        } finally {
            lock.unlock();
        }
    }



}
