package de.telran.practice_lesson_25;

public class Table {

    String box;

    public synchronized String get() throws InterruptedException {
        if (this.box == null) {
            wait();
        }
            String currentBox = box;
            box = null;
        System.out.println("Забираем со стола " + currentBox);
            notify();
            return currentBox;
    }

    public synchronized void put(String box) throws InterruptedException {
        if (this.box != null) {
            wait();
        }
            this.box = box;
        System.out.println(" Кладем на стол коробку " + box);
            notify();

    }
}
