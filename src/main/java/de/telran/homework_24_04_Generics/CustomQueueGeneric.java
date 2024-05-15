package de.telran.homework_24_04_Generics;

import java.util.ArrayDeque;

public class CustomQueueGeneric <T>{


    private ArrayDeque<T> deque = new ArrayDeque<>();

    public void enqueue(T data) {
        deque.add(data);
    }

    public T dequeue(){
        return deque.removeFirst();
    }


    public static void main(String[] args) {
        CustomQueueGeneric<Double> myQueue = new CustomQueueGeneric();
        myQueue.enqueue(1.0);
        myQueue.enqueue(2.1);
        myQueue.enqueue(3.4);


        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());

        CustomQueueGeneric<String> myStringQueue = new CustomQueueGeneric();
        myStringQueue.enqueue("A");
        myStringQueue.enqueue("B");
        myStringQueue.enqueue("C");


        System.out.println(myStringQueue.dequeue());
        System.out.println(myStringQueue.dequeue());
        System.out.println(myStringQueue.dequeue());

    }
}
