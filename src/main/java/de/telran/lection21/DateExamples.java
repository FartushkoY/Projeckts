package de.telran.lection21;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateExamples {

    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        System.out.println(now.getTime());

        Date date = new Date(1000L);
        System.out.println(date);

        System.out.println(new Date(100, 1, 5));
        System.out.println(new Date(100, 12, 35));

        Date date1 = new Date(100, Calendar.DECEMBER, 5);
        System.out.println(date1);

        System.out.println(date1.compareTo(date));
        date1.setHours(10);
        System.out.println(date1);


        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(format.format(now));

        Locale locale = Locale.GERMAN;
        Locale.setDefault(locale);
//
//        System.out.println(date1.toInstant());
//        System.out.println(date1.toInstant().getClass());
//
//        Calendar calendar = new GregorianCalendar();
//        System.out.println(calendar);
//        System.out.println(calendar.getCalendarType());


    }
}
