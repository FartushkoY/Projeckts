package de.telran.practice_lesson_7;
import de.telran.practice_lesson_5.DynamicIntArray;
import de.telran.practice_lesson_6.LinkedListIntSingly;

import java.util.ArrayList;
import java.util.LinkedList;

public class SimpleTestSpeedDeleteValue {
    public static void main(String[] args) {

        long startTime, endTime;


        // DynamicIntArray
        DynamicIntArray dynamicIntArray = new DynamicIntArray();
        for (int i = 0; i < 100000; i++) {
            dynamicIntArray.add(i);
        }

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            if(i>=1) {
                Integer val = dynamicIntArray.getElem(dynamicIntArray.getLength() / 2);
                dynamicIntArray.deleteValue(val);
            }
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
                Integer val = arrayList.get(arrayList.size() / 2);
                arrayList.remove(val);
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList delete object = "+(endTime-startTime));


        // LinkedListIntSingly - вне конкурса
        LinkedListIntSingly linkedListIntSingly = new LinkedListIntSingly();
        for (int i = 0; i < 100000; i++) {
            linkedListIntSingly.addFirst(i);
        }
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedListIntSingly.delete(linkedListIntSingly.getSize()/2);
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
                Integer val = linkedList.get(linkedList.size()/2);
                linkedList.remove(val);
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList delete = "+(endTime-startTime));

    }
}