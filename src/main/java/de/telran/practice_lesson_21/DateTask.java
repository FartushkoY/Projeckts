package de.telran.practice_lesson_21;

// 1) реализовать метод, который принимает год и проверяет на високосность
//2) вывести на консоль дату локализованную для Индии (например)
//9) получить возраст человека на текущий момент, если известна его дата рождения.
// 10) Вы просыпаетесь и смотрите на будильник. Вам на работу нужно на 9 часов. Узнайте, сколько времени
//    осталось еще до начала работы или если вы проспали, то на сколько.
//
//3) вывести дату в формате 19-12-22, 19, 353, 11:47 <дата, день месяца, день в году, время>
//            4) создать дату своего рождения, вывести на консоль в формате "10 Января 1985"
//            5) проверить дата "10 Января 1985" - это пятница, попробуйте получить день недели для любой другой даты?
//            6) вычесть 10 лет из созданной даты, вывести на консоль
//7) получить обьект Instant из "2022-12-19T06:55:30.00Z", вывести на консоль
//8) получить ZonedDateTime из "Pacific/Midway", вывести на консоль

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите год: ");
//        int date = scanner.nextInt();
//        System.out.printf("%d год високосный? %b", date, isLeapYear(date));

        ZoneId zoneId = ZoneId.of("Indian/Kerguelen");
        System.out.println(LocalDate.now(zoneId));
        System.out.println(LocalDateTime.now(zoneId));
        System.out.println(ZonedDateTime.now(zoneId));

//        System.out.print("Введите год рождения: ");
//        int year = scanner.nextInt();
//        System.out.print("Введите месяц рождения: ");
//        int month = scanner.nextInt();
//        System.out.print("Введите день рождения: ");
//        int day = scanner.nextInt();
//        LocalDate birthday = LocalDate.of(year, month, day);
//        LocalDate currentDate = LocalDate.now();
//        System.out.println(ChronoUnit.YEARS.between(birthday, currentDate));
        System.out.println(ChronoUnit.MINUTES.between(LocalTime.now(), LocalTime.of(9, 0)));
        System.out.println(overslept());

//        System.out.printf("%d"LocalDateTime.of(2022, 12, 22, 11, 47));

    }

    public static boolean isLeapYear(int date) {
        LocalDate localDate = LocalDate.of(date, 1, 1);
        return localDate.isLeapYear();
    }

    public static String overslept(){
        LocalTime time = LocalTime.now();
        LocalTime workTime = LocalTime.of(9, 0);
        long min = ChronoUnit.MINUTES.between(time, workTime) - ChronoUnit.HOURS.between(time, workTime)*60;

        return "You can sleep " + ChronoUnit.HOURS.between(time, workTime) + " hours " + min + " min";
    }



}
