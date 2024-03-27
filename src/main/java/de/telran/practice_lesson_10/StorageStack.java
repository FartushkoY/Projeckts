package de.telran.practice_lesson_10;

import java.util.Stack;

public class StorageStack {
    private Stack<BrickPack> brickPackStack;

    private int size;
    private int count;

    public StorageStack(int size) {
        this.size = size;
        brickPackStack = new Stack<>();
    }

    public void print() {
        System.out.println(brickPackStack);
        System.out.println("Size = " + size);
        System.out.println("Count = " + count);
    }

    public boolean storagePush(BrickPack brickPack) {
        if (brickPack == null) {
            return false;
        }
        if (count < size) {
            brickPackStack.push(brickPack);
            count++;
            return true;
        }
        System.err.println("Склад переполнен. Не удалось добавить пакет " + brickPack);
        return false;
    }

    public BrickPack storagePeek() {
        if (count > 0) {
            return brickPackStack.peek();
        }
        System.out.println("Склад пустой");
        return null;
    }

    public BrickPack storagePop() {
        if (count > 0) {
            count--;
            return brickPackStack.pop();
        }
        System.err.println("Склад пустой");
        return null;
    }




}
