package de.telran.summary3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList implements Iterable<String>{

    private String[] data;

    public MyArrayList(String[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    @Override
    public Iterator<String> iterator() {
        return new MyArrayListIterator();
    }

    public Iterator<String> reverseIterator() {
        return new MyArrayListReverseIterator();
    }

    public class MyArrayListIterator implements Iterator<String>{

        int currentIndex = 0;


        @Override
        public boolean hasNext() {
            return currentIndex < data.length;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("no elements present");
            }
            return data[currentIndex++];
        }
    }

    public class MyArrayListReverseIterator implements Iterator<String>{

        int currentIndex = data.length - 1;


        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("no elements present");
            }
            return data[currentIndex--];
        }
    }


    public static void main(String[] args) {
        String[] data = new String[] {"A", "B", "C", "D", "E"};
//        MyArrayList = new MyArrayList(data);
    }

}
