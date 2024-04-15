package de.telran.summary3.task;



import java.util.Iterator;
import java.util.NoSuchElementException;

public class Box implements Iterable{
    private String itemA;
    private String itemB;
    private String itemC;

    public Box(String itemA, String itemB, String itemC) {
        this.itemA = itemA;
        this.itemB = itemB;
        this.itemC = itemC;
    }

    public String getItemA() {
        return itemA;
    }

    public void setItemA(String itemA) {
        this.itemA = itemA;
    }

    public String getItemB() {
        return itemB;
    }

    public void setItemB(String itemB) {
        this.itemB = itemB;
    }

    public String getItemC() {
        return itemC;
    }

    public void setItemC(String itemC) {
        this.itemC = itemC;
    }



    @Override
    public Iterator iterator() {
        return new MyBoxIterator();
    }

    public class MyBoxIterator implements Iterator<String>{

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < 3;
        }

        @Override
        public String next() {

                if (!hasNext()) {
                    throw new NoSuchElementException("no elements present");
                }
               String current;
                switch (currentIndex) {
                    case 0 -> current = getItemA();   // A
                    case 1 -> current = getItemB();   // B
                    default -> current = getItemC();   // C
                }
                currentIndex++;
                return current;
        }
    }



    public static void main(String[] args) {
        Box box = new Box("A", "B", "C");

        Iterator<String> myIteratorBox = box.iterator();
        while (myIteratorBox.hasNext()) {
            System.out.println(myIteratorBox.next());
        }

    }
}
