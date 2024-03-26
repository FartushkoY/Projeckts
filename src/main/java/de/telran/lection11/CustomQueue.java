package de.telran.lection11;

import java.util.ArrayDeque;

public class CustomQueue {

    private ArrayDeque<String> deque = new ArrayDeque<>();

    public void enqueue(String data) {
        deque.add(data);
    }

    public String dequeue(){
        return deque.removeFirst();
    }


    public static void main(String[] args) {
        CustomQueue myQueue = new CustomQueue();
        myQueue.enqueue("A");
        myQueue.enqueue("B");
        myQueue.enqueue("C");

        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue() );
    }
}
