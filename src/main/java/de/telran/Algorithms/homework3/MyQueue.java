package de.telran.Algorithms.homework3;

import java.util.LinkedList;

public class MyQueue {
    private LinkedList<Integer> myQueue;
    private int counter;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue(int capacity) {
        this.myQueue = new LinkedList<>();
        this.capacity = capacity;
    }

    public MyQueue() {
        this.myQueue = new LinkedList<>();
        this.capacity = DEFAULT_CAPACITY;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "myQueue=" + myQueue +
                ", counter=" + counter +
                ", capacity=" + capacity +
                '}';
    }

    public void add(int element) {
        if (counter == capacity) {
            System.err.println("Queue is full");
        }
        else {
            myQueue.addFirst(element);
            counter++;
        }
    }

    public int remove() {
        int res = -1;
        if (counter == 0) {
            System.err.println("Queue is empty");
        } else {
            res = myQueue.getLast();
            myQueue.removeLast();
            counter--;
        }
        return res;
    }

    public int element() {
        int res = -1;
        if (counter == 0) {
            System.err.println("Queue is empty");
        } else {
            res = myQueue.getLast();
        }
        return res;
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue);
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);
        myQueue.add(9);
        myQueue.add(10);
//        myQueue.add(11);
        System.out.println(myQueue);
        System.out.println(myQueue.element());
        System.out.println(myQueue);
        System.out.println(myQueue.remove());
        System.out.println(myQueue);
        System.out.println(myQueue.element());
        System.out.println(myQueue);
        System.out.println(myQueue.remove());
        System.out.println(myQueue);
        System.out.println(myQueue);
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        System.out.println(myQueue);
    }


}
