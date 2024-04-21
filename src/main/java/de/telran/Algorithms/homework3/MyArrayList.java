package de.telran.Algorithms.homework3;

import java.util.Arrays;


public class MyArrayList {
    private int[] myArray;
    private int lenght;
    private int capacity;

    private static final int DEFAULT_CAPACITY = 16;
    private static final int PERCENT_CHANGE = 2;

    public MyArrayList() {
        myArray = new int[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        myArray = new int[capacity];
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "myArray=" + Arrays.toString(myArray) +
                ", lenght=" + lenght +
                ", capacity=" + capacity +
                '}';
    }

    public void add(int element) {
        if (lenght < capacity) {
            myArray[lenght++] = element;
        } else {
            capacity = capacity * PERCENT_CHANGE;
            myArray = Arrays.copyOf(myArray, capacity);
            add(element);
        }
    }

    public void remove(int index) {
        for (int i = index; i < lenght + 1; i++) {
            myArray[i] = myArray[i + 1];
        }
        myArray[lenght - 1] = 0;
        lenght--;
        if (lenght < capacity / PERCENT_CHANGE) {
            capacity = (int) (capacity / PERCENT_CHANGE + lenght * 0.2);
            myArray = Arrays.copyOf(myArray, capacity);
        }
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i < 17; i++) {
            myArrayList.add(i);
        }
        System.out.println(myArrayList);
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);

        System.out.println(myArrayList);
    }
}

