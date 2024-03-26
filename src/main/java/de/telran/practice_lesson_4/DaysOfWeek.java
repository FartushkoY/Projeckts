package de.telran.practice_lesson_4;

public class DaysOfWeek {

    private String title;


    public DaysOfWeek() {
    }

    private DaysOfWeek(String title) {
        this.title = title;
    }

    public static DaysOfWeek MONDAY = new DaysOfWeek("Monday");
    public static DaysOfWeek TUESDAY = new DaysOfWeek("Tuesday");
    public static DaysOfWeek WEDNESDAY = new DaysOfWeek("Wednesday");
    public static DaysOfWeek THURSDAY = new DaysOfWeek("Thursday");
    public static DaysOfWeek FRIDAY = new DaysOfWeek("Friday");
    public static DaysOfWeek SATURDAY = new DaysOfWeek("Satarday");
    public static DaysOfWeek SUNDAY = new DaysOfWeek("Sunday");






    @Override
    public String toString() {
        return "DaysOfWeek{" +
                "title='" + title + '\'' +
                '}';
    }
}
