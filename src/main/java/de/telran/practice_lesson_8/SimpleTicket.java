package de.telran.practice_lesson_8;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SimpleTicket {

    public static void main(String[] args) {
        Set<Ticket> ticketSet = new HashSet<>();
        ticketSet.add(new Ticket(23,"fio1"));
        ticketSet.add(new Ticket(7,"fio2"));
        ticketSet.add(new Ticket(3,"fio3"));
        ticketSet.add(new Ticket(10,"fio4"));
        System.out.println(ticketSet);

        Set<Ticket> ticketSetSort = new TreeSet<>(new Comparator<Ticket>() {
            @Override
            public int compare(Ticket o1, Ticket o2) {
                return o1.num - o2.num;
            }
        });
        ticketSetSort.addAll(ticketSet);
        System.out.println(ticketSetSort);


    }
}
