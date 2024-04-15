package de.telran.practice_lesson_11;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Transport transport1 = new Transport("ambulance1", 1, TransportTypes.AMBULANCE);
        Transport transport2 = new Transport("auto1", 2, TransportTypes.AUTO);
        Transport transport3 = new Transport("bus", 2, TransportTypes.BUS);
        Transport transport4 = new Transport("auto2", 2, TransportTypes.AUTO);
        Transport transport5 = new Transport("service1", 2, TransportTypes.SERVICE);
        Transport transport6 = new Transport("auto3", 2, TransportTypes.AUTO);

        Queue<Transport> transportQueue = new PriorityQueue<>();
        transportQueue.add(transport6);
        transportQueue.add(transport5);
        transportQueue.add(transport1);
        transportQueue.add(transport3);
        transportQueue.add(transport2);
        transportQueue.add(transport4);

        System.out.println(transportQueue);
        System.out.println(transportQueue.peek());
        System.out.println("----------------");

        Queue<Transport> transportQueueRushHour = new PriorityQueue<>(new Transport.comparatorRushHour());
        transportQueueRushHour.addAll(transportQueue);
        System.out.println(transportQueueRushHour);
        System.out.println(transportQueueRushHour.peek());
        System.out.println(transportQueueRushHour.remove());
        System.out.println(transportQueueRushHour.peek());
        System.out.println(transportQueueRushHour.remove());
        System.out.println(transportQueueRushHour.remove());
        System.out.println(transportQueueRushHour.remove());

        System.out.println("----------------");
        Queue<Transport> transportQueueAlarm = new PriorityQueue<>(new Transport.comparatorAlarm());
        transportQueueAlarm.addAll(transportQueue);

        System.out.println(transportQueueAlarm);
        System.out.println(transportQueueAlarm.remove());
        System.out.println(transportQueueAlarm.remove());
        System.out.println(transportQueueAlarm.remove());
        System.out.println(transportQueueAlarm.remove());


    }



}
