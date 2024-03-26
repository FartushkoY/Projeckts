package de.telran.practice_lesson_4;

public class SimpleNoEnum {
    public static void main(String[] args) {

//        DaysOfWeek daysOfWeek1 = new DaysOfWeek("Monday");    т к конструктор приватный, то мы нне можем создавать объекты извне
//        DaysOfWeek daysOfWeek2 = new DaysOfWeek("Tuesday");   таким образом ограничены возможные значения
//        DaysOfWeek daysOfWeek3 = new DaysOfWeek("Wednesday"); такой метод использовался до того, как был внесен enum в java
//        System.out.println(daysOfWeek1);

        DaysOfWeek daysOfWeek1 = DaysOfWeek.MONDAY;
        System.out.println(daysOfWeek1);
        DaysOfWeek daysOfWeek2 = DaysOfWeek.TUESDAY;
        System.out.println(daysOfWeek2);

        DayOfWeekEnum dayOfWeekEnum = DayOfWeekEnum.SATURDAY;
        System.out.println(dayOfWeekEnum);

        System.out.println();
        for (DayOfWeekEnum day: DayOfWeekEnum.values()) {
            System.out.println(day);
            System.out.println(day.getCountCalories());
        }

    }
}
