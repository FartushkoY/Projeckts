package de.telran.practice_lesson_7;
import de.telran.practice_lesson_5.DynamicIntArray;
import de.telran.practice_lesson_6.LinkedListIntSingly;

import java.util.ArrayList;
import java.util.LinkedList;

public class SimpleTestSpeedDelete {
    public static void main(String[] args) {

        long startTime, endTime;


        // DynamicIntArray
        DynamicIntArray dynamicIntArray = new DynamicIntArray();
        for (int i = 0; i < 100000; i++) {
            dynamicIntArray.add(i);
        }

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            dynamicIntArray.delete(i/2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("DynamicIntArray delete = "+(endTime-startTime));

        // ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {

            if(i>=1) {
                int index = arrayList.size()/2;
                arrayList.remove(index);
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList delete = "+(endTime-startTime));


        // LinkedListIntSingly - вне конкурса
        LinkedListIntSingly linkedListIntSingly = new LinkedListIntSingly();
        for (int i = 0; i < 100000; i++) {
            linkedListIntSingly.addFirst(i);
        }
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedListIntSingly.delete(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedListIntSingly delete = "+(endTime-startTime));


        //LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            if(i>=1) {
                int index = linkedList.size()/2;
                linkedList.remove(index);
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList delete = "+(endTime-startTime));

    }
}