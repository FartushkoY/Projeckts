package de.telran.homework_13_05_Date;


import java.time.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {

//        1) Составить список времен начала всех занятий по Java за июнь,
//        если предположить, что они будут проходить каждый понедельник/среду c 9:30 CET.

        LocalDate localDate = LocalDate.of(2024, 6, 1);
        LocalTime localTime = LocalTime.of(9, 30);

        List<ZonedDateTime> timetable = localDate.datesUntil(localDate.of(2024, 6, 30))
                .filter(d -> d.getDayOfWeek() == DayOfWeek.MONDAY
                        || d.getDayOfWeek() == DayOfWeek.WEDNESDAY)
                .map(d -> ZonedDateTime.of(d, localTime, ZoneId.of("CET"))).toList();
        System.out.println(timetable);
        System.out.println("------------");


//        2) Рейс из Лос-Анджелеса во Франкфурт отправляется в 15:05 по местному времени
//        и длится 10 ч. 50 м. Во сколько он прилетит?
//        Написать метод, который мог бы совершать подобные вычисления.


        // Я использовала LocalDate.now() в предыдущей версии потому что нам нужно перейти к типу  ZonedDateTime,
        // a время прилета самолета не зависит от даты, когда он вылетит.
        //  И результат нам нужен в виде только времени.
        // Но ок, тогда даем на вход дату и время вылета.

        LocalDateTime departureDataTime = LocalDateTime.of(2024, 5, 25, 15, 5);
        ZoneId departureZoneID = ZoneId.of("America/Los_Angeles");
        ZoneId arrivalZoneID = ZoneId.of("Europe/Berlin");
        Duration duration = Duration.ofMinutes(650);
        // альтернативная запись
        Duration durationHM = Duration.ofHours(10).plusMinutes(50);
//        System.out.println(durationHM);
        System.out.println(getArrivalTime(departureDataTime, departureZoneID, duration, arrivalZoneID));
        System.out.println(getArrivalTime(departureDataTime, departureZoneID, durationHM, arrivalZoneID));
    }

    public static LocalDateTime getArrivalTime(LocalDateTime departureDataTime, ZoneId departureZoneID,
                                           Duration duration, ZoneId arrivalZoneID) {
        return ZonedDateTime.of(departureDataTime, departureZoneID).plus(duration)
                .withZoneSameInstant(arrivalZoneID).toLocalDateTime();
    }
}
