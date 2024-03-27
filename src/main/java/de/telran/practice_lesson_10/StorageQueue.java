package de.telran.practice_lesson_10;

import java.util.LinkedList;
import java.util.Queue;

public class StorageQueue {
    private Queue<BrickPack> brickPackQueue;
    private int size;
    private int count;

    public StorageQueue(int size) {
        this.size = size;
        brickPackQueue = new LinkedList<>();
    }

    public void print() {
        System.out.println(brickPackQueue);
        System.out.println("Size = " + size);
        System.out.println("Count = " + count);
    }

    public boolean storagePush(BrickPack brickPack) {
        if (brickPack == null) {
            return false;
        }
        if (count < size) {
            brickPackQueue.offer(brickPack);
            count++;
            return true;
        }
        System.err.println("Склад переполнен. Не удалось добавить пакет " + brickPack);
        return false;
    }

    public BrickPack storagePeek() {
        if (count > 0) {
            return brickPackQueue.peek();
        }
        System.out.println("Склад пустой");
        return null;
    }

    public BrickPack storagePoll() {
        if (count > 0) {
            count--;
            return brickPackQueue.poll();
        }
        System.err.println("Склад пустой");
        return null;
    }


}
