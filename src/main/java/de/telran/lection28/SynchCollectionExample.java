package de.telran.lection28;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchCollectionExample {

    public static void main(String[] args) {

        Vector<String> vector = new Vector<>();
        vector.add("A"); // операции c vector потокобезопасны
        vector.remove(0);

        List<String> list = new ArrayList<>();
//        list.add("A");  // не потокобезопасные операции
        List<String> synchronizedList = Collections.synchronizedList(list);
        synchronizedList.add("A"); // потокобезопасны
        synchronizedList.add("B");

        synchronized (synchronizedList) {       // с блоком синхронизации - потокобезопано
            if (synchronizedList.size() == 2) { // 2 операции, кот разнесены во времени, может вмешаться другой поток
                synchronizedList.add("C");         // не потокобезопасны
            }
        }

//        Collections.synchronizedSet()    и для других коллекций

//        for (String s : synchronizedList) {
//            System.out.println(s);
////            synchronizedList.add("New value");// ConcurrentModificationException  нельзя одновременно перебирать и менять данные
////            synchronizedList.remove(0); // ConcurrentModificationException
//        }
        synchronized (synchronizedList) {
            Iterator<String> iterator = synchronizedList.iterator();
            while (iterator.hasNext()) {                    // нужен поток синхронизации даже для synchronized-коллекций
                String data = iterator.next();
                System.out.println(data);
                if (data.equals("B")) iterator.remove();
            }
        }
        System.out.println(synchronizedList);


        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        List<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        copyOnWriteList.add("A");
        copyOnWriteList.add("B");
        copyOnWriteList.add("C");

        //thread 1:
        for (String s : copyOnWriteList) {
            System.out.println(s);
        }

        //thread 2:
        copyOnWriteList.remove(0);


    }
}
