package de.telran.homework_08_04_Map_Hash;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ticket {

    private String departure;
    private String destination;

    public Ticket(String departure, String destination) {
        this.departure = departure;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("Berlin", "London");
        Ticket ticket2 = new Ticket("Tokyo", "Seoul");
        Ticket ticket3 = new Ticket("Mumbai", "Berlin");
        Ticket ticket4 = new Ticket("Seoul", "Mumbai");
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket1);
        ticketList.add(ticket2);
        ticketList.add(ticket3);
        ticketList.add(ticket4);

        printRoute(ticketList);

    }

    public static void printRoute(List<Ticket> ticketList) {
        Map<String, String> ticketMap = new HashMap<>();
        for (Ticket ticket : ticketList) {
            ticketMap.put(ticket.departure, ticket.destination);
        }
//        System.out.println(ticketMap);
        String city = ticketList.get(0).departure;
        while (ticketMap.containsKey(city)) {
            city = ticketMap.get(city);
        }
        Map<String, String> roteMap = new HashMap<>();
        for (Ticket ticket : ticketList) {
            roteMap.put(ticket.destination, ticket.departure);
        }
//        System.out.println(roteMap);
//        System.out.println(city);
        while (roteMap.containsKey(city)) {
            city = roteMap.get(city);

//            System.out.println(city);
        }
        while (ticketMap.containsKey(city)) {
            System.out.println(city + " -- " + ticketMap.get(city));
            city = ticketMap.get(city);
        }
    }
}
