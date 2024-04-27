package de.telran.Algorithms.homework3;

import java.util.Arrays;

public class MyStackArray {
   private int[] myStack;
   private int capacity;
   private int counter;

   private static final int DEFAULT_CAPACITY = 10;

    public MyStackArray() {
        myStack = new int[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public MyStackArray(int capacity) {
        myStack = new int[capacity];
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "MyStackArray{" +
                "myStack=" + Arrays.toString(myStack) +
                ", capacity=" + capacity +
                ", counter=" + counter +
                '}';
    }


    public boolean isEmpty() {
        return counter == 0;
    }

    public void push(int element) {
        if (counter == capacity) {
            System.err.println("Stack заполнен. Невозможно добавить новый элемент");
        } else {
            myStack[counter++] = element;
        }
    }

    public int pop() {
        int res = -1;
        if (counter == 0) {
            System.out.println("Stack is empty");
        } else {
            res = myStack[counter - 1];
            myStack[counter - 1] = 0;
            counter--;
        }
        return res;
    }

    public static void main(String[] args) {
        MyStackArray myStackArray = new MyStackArray(5);
        myStackArray.push(1);
        myStackArray.push(2);
        myStackArray.push(3);
        myStackArray.push(4);
//        myStackArray.push(5);
        System.out.println(myStackArray);
        System.out.println(myStackArray.pop());
        System.out.println(myStackArray.isEmpty());
        System.out.println(myStackArray.pop());
        System.out.println(myStackArray.pop());
        System.out.println(myStackArray.pop());
        System.out.println(myStackArray.pop());
        System.out.println(myStackArray);
        System.out.println(myStackArray.isEmpty());


    }

}
