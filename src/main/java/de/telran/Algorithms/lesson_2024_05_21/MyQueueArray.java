package de.telran.Algorithms.lesson_2024_05_21;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MyQueueArray {
    private int[] myQueue;
    private int head;
    private int tail;
    private int capacity;
    private int counter;
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

    // допилить! некорректно добавляет)
    public void add(int element) {
        if (counter == capacity) {
            System.out.println("Queue is full");
        } else {
            myQueue[tail % capacity] = element;
            counter++;
            tail = (tail+1) %capacity;

        }
    }

    public int remove() {
        int res = -1;
        if (counter == 0) {
            System.out.println("Queue is empty");
        } else {
            res = myQueue[head];
            myQueue[head] = 0;
            head = (head+1) %capacity;
            counter--;
        }
        return res;
    }


    public int element() {
        int res = -1;
        if (counter == 0) {
            System.out.println("Queue is empty");
        } else {
            res = myQueue[head];
        }
        return res;
    }


    public static void main(String[] args) {
        MyQueueArray myQueueArray = new MyQueueArray(6);
//        System.out.println(myQueueArray.element());
        myQueueArray.add(1);
        myQueueArray.add(2);
        myQueueArray.add(3);
        myQueueArray.add(4);
        myQueueArray.add(5);
        myQueueArray.add(6);
        myQueueArray.add(7);
        System.out.println(myQueueArray);
        System.out.println("element");
        System.out.println(myQueueArray.element());
        System.out.println("remove");
        System.out.println(myQueueArray.remove());
        System.out.println(myQueueArray);
        System.out.println("add");
        myQueueArray.add(7);
        System.out.println(myQueueArray);
        System.out.println("element");
        System.out.println(myQueueArray.element());
        System.out.println("remove");
        System.out.println(myQueueArray.remove());
        System.out.println(myQueueArray);
        System.out.println("add");
        myQueueArray.add(8);
        System.out.println(myQueueArray);
        System.out.println("remove");
        System.out.println(myQueueArray.remove());
        System.out.println("remove");
        System.out.println(myQueueArray.remove());
        System.out.println(myQueueArray);
        System.out.println("add");
        myQueueArray.add(9);
        System.out.println(myQueueArray);
        System.out.println("remove");
        System.out.println(myQueueArray.remove());
        System.out.println("remove");
        System.out.println(myQueueArray.remove());
        System.out.println("remove");
        System.out.println(myQueueArray.remove());
        System.out.println("remove");
        System.out.println(myQueueArray.remove());
        System.out.println("remove");
        System.out.println(myQueueArray.remove());
        System.out.println(myQueueArray);



    }
}
