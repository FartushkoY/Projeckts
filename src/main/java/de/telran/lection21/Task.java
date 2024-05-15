package de.telran.lection21;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class Task {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, Month.AUGUST, 18);
        DateTimeFormatter datLoc = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(datLoc.withLocale(Locale.ENGLISH).format(date));
        System.out.println(datLoc.withLocale(Locale.GERMANY).format(date));
        System.out.println(date.getDayOfWeek());
        System.out.println(date.minusYears(10));
        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), date));

        LocalDate localDate = LocalDate.of(2024, Month.SEPTEMBER, 1);
        System.out.println(localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY)));
        LocalDate mayLocalDate = LocalDate.of(2024, Month.MAY, 1);
        System.out.println(mayLocalDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.WEDNESDAY)).plusWeeks(1));


    }
}
