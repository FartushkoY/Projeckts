package de.telran.summary3.task;



import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SquareArrayList implements Iterable{
    private int[][] data;

    public SquareArrayList(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SquareArrayList{" +
                "data=" + Arrays.toString(data) +
                '}';
    }



    @Override
    public Iterator iterator() {
        return new MySquareArrayListIterator();
    }

    public class MySquareArrayListIterator implements Iterator<Integer> {
        int i = 0;
        int j = 0;
        int lineCount = data.length;
        int columnCount = data[0].length;


        @Override
        public boolean hasNext() {
            return (i < lineCount && j < columnCount);
        }


        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("no elements present");
            }
            Integer current = data[i][j++];
                if (j >= columnCount) {
                    i++;
                    j = 0;
                }
            return current;
        }
    }


    public static void main(String[] args) {
        int[][] squareArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SquareArrayList squareArrayList = new SquareArrayList(squareArray);

        Iterator<SquareArrayList> myIteratorSquareArray = squareArrayList.iterator();
        while (myIteratorSquareArray.hasNext()) {
            System.out.println(myIteratorSquareArray.next());
        }
    }
}

