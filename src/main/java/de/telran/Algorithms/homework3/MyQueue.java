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

    public void push(int element) {
        if (counter == capacity) {
            System.err.println("Queue is full");
        }
        else {
            myQueue.addFirst(element);
            counter++;
        }
    }

    public int pop() {
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

    public int peek() {
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
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        myQueue.push(6);
        myQueue.push(7);
        myQueue.push(8);
        myQueue.push(9);
        myQueue.push(10);
//        myQueue.add(11);
        System.out.println(myQueue);
        System.out.println(myQueue.peek());
        System.out.println(myQueue);
        System.out.println(myQueue.pop());
        System.out.println(myQueue);
        System.out.println(myQueue.peek());
        System.out.println(myQueue);
        System.out.println(myQueue.pop());
        System.out.println(myQueue);
        System.out.println(myQueue);
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        System.out.println(myQueue);
    }


}
