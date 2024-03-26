package de.telran.practice_lesson_5;

import java.util.Arrays;

public class CopyDynamicIntArray {
    private int lenght;
    private int capacity;
    private int[] arr; // = new int[DEFAULT_CAPACITY];
    public static final int DEFAULT_CAPACITY = 10;
    public static final double PERCENT_CHANGE = 1.5;

    public CopyDynamicIntArray() {
        arr = new int[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public CopyDynamicIntArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }


    @Override
    public String toString() {
        return "DinamicIntArray{" +
                "lenght=" + lenght +
                ", capacity=" + capacity +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }


    public void add(int element) {
        if (lenght < capacity) {
//        arr[lenght] = element;
//        lenght++;                         аналогичные записи
            arr[lenght++] = element;
        } else {
            int newCapacity = ((int) (capacity * PERCENT_CHANGE));
            int[] newArr = new int[newCapacity];
            capacity = newCapacity;
            copyElements(arr, newArr);
            arr = newArr;
            add(element);
        }
    }


    public void add(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }

//        if (lenght + elements.length < capacity) {
//            copyElements(arr, elements, lenght);
//            lenght = lenght + elements.length;
//        } else {
//            int newCapacity = ((int)(capacity * PERCENT_CHANGE));
//            if (newCapacity < (lenght + elements.length)) {
//                newCapacity = (int)((lenght + elements.length) * PERCENT_CHANGE);
//            }
//            int[] newArr = new int[newCapacity];
//            capacity = newCapacity;
//            copyElements(arr, newArr);
//            arr = newArr;
//            add(elements);
//        }
    }

    private void copyElements(int[] oldArr, int[] newArr) {
        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }
    }

    private void copyElements(int[] oldArr, int[] newElements, int startIndex) {
        int start = startIndex;
        for (int i = 0; i < newElements.length; i++) {
            oldArr[start] = newElements[i];
            start++;
        }
    }

    public int getElem(int index) {
        return arr[index];
    }

    public void delete(int index) {
        for (int i = index; i < arr.length - 1; i++) {
            int tmp = arr[i + 1];
            arr[i] = tmp;
        }
        arr[lenght] = 0;
        lenght--;
    }

    public void insert(int index, int element) {
        if (lenght < capacity) {
            for (int i = capacity - 1; i < index; i++) {
                int tmp = arr[i - 1];
                arr[i] = tmp;
            }
            arr[index] = element;
            lenght++;
        } else {
            int[] newArr = new int[((int) (capacity * PERCENT_CHANGE))];
            capacity = ((int) (capacity * PERCENT_CHANGE));
            copyElements(arr, newArr);
            arr = newArr;
            insert(index, element);
        }
    }

}
