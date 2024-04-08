package de.telran.lection13;

import java.util.*;

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
        List<Ticket> ticketList = Arrays.asList(ticket1, ticket2, ticket3, ticket4);

        printRoute(ticketList);

    }

    public static void printRoute(List<Ticket> ticketList) {
        Map<String, String> ticketMap = new HashMap<>();
        for (Ticket ticket: ticketList) {
            ticketMap.put(ticket.departure, ticket.destination);
        }
        String city = ticketList.get(0).departure;
        while (ticketMap.containsKey(city)) {
            city = ticketMap.get(city);
        }
        System.out.println(city);

        Map<String, String> roteMap = new HashMap<>();
        for (Ticket ticket: ticketList) {
            ticketMap.put(ticket.destination, ticket.departure);
        }
        while (roteMap.containsKey(city)) {
            city = roteMap.get(city);
            System.out.println(city);
        }
    }
}
