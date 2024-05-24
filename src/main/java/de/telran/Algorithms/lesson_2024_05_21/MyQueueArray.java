package de.telran.Algorithms.lesson_2024_05_21;

import java.util.Arrays;

public class MyQueueArray {
    private int[] myQueue;
    private int head;
    private int tail;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;


    public MyQueueArray(int capacity) {

        this.capacity = capacity;
        this.myQueue = new int[capacity];
    }

    public MyQueueArray() {
        this.capacity = DEFAULT_CAPACITY;
        this.myQueue = new int[capacity];
    }

    @Override
    public String toString() {
        return "MyQueueArray{" +
                "myQueue=" + Arrays.toString(myQueue) +
                ", head=" + head +
                ", tail=" + tail +
                ", capacity=" + capacity +
                '}';
    }

    public void add(int element) {
        if (tail == capacity && head == 0) {
            System.err.println("Queue is full");
        }
        else {
            myQueue[tail] = element;
            tail++;

        }
    }

    public int remove() {
        int res = -1;
        if (head == tail) {
            System.err.println("Queue is empty");
        } else {
            res = myQueue[head];
            myQueue[head] = 0;
            head++;
        }
        return res;
    }


    public int element() {
        int res = -1;
        if (head == tail) {
            System.err.println("Queue is empty");
        } else {
            res = myQueue[head];
        }
        return res;
    }


    public static void main(String[] args) {
        MyQueueArray myQueueArray = new MyQueueArray(10);
        System.out.println(myQueueArray.element());
        myQueueArray.add(4);
        myQueueArray.add(5);
        myQueueArray.add(8);
        System.out.println(myQueueArray);
        System.out.println(myQueueArray.element());
        System.out.println(myQueueArray.remove());
        System.out.println(myQueueArray.element());
        System.out.println(myQueueArray.remove());
        System.out.println(myQueueArray.remove());
        System.out.println(myQueueArray.remove());


    }
}
