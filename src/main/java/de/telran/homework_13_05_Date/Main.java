package de.telran.homework_13_05_Date;


import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.List;


public class Main {
    public static void main(String[] args) {

//        1) Составить список времен начала всех занятий по Java за июнь,
//        если предположить, что они будут проходить каждый понедельник/среду c 9:30 CET.

        LocalDate localDate = LocalDate.of(2024, 6, 1);
        LocalTime localTime = LocalTime.of(9, 30);

        List<ZonedDateTime> times = localDate.datesUntil(localDate.of(2024, 6, 30))
                .filter(d -> d == d.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY))
                        || d == d.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)))
                .map(d -> ZonedDateTime.of(d, localTime, ZoneId.of("CET"))).toList();
        System.out.println(times);
        System.out.println("------------");


//        2) Рейс из Лос-Анджелеса во Франкфурт отправляется в 15:05 по местному времени
//        и длится 10 ч. 50 м. Во сколько он прилетит?
//        Написать метод, который мог бы совершать подобные вычисления.


        LocalTime departureTime = LocalTime.of(15, 05);
        ZoneId departureZoneID = ZoneId.of("America/Los_Angeles");
        int flightDurationHours = 10;
        int flightDurationMin = 50;
        ZoneId arrivalZoneID = ZoneId.of("Europe/Berlin");

        System.out.println(getArrivalTime(departureTime, departureZoneID, flightDurationHours, flightDurationMin, arrivalZoneID));


    }

    public static LocalTime getArrivalTime(LocalTime departureTime, ZoneId departureZoneID,
                                           int flightDurationHours, int flightDurationMin, ZoneId arrivalZoneID) {

        ZonedDateTime departureZonedDateTime = ZonedDateTime.of(LocalDate.now(), departureTime, departureZoneID);
        return departureZonedDateTime.plusHours(flightDurationHours)
                .plusMinutes(flightDurationMin).withZoneSameInstant(arrivalZoneID).toLocalTime();
    }
}
