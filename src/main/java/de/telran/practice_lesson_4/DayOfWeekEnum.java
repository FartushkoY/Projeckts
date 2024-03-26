package de.telran.practice_lesson_4;

public enum DayOfWeekEnum {

    MONDAY("Monday"),
    TUESDAY("Tuesday", 1000),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday", 3000),
    FRIDAY("Friday"),
    SATURDAY("Satarday", 5000),
    SUNDAY("Sunday");

    private String title;
    private int countCalories;

    DayOfWeekEnum(String title) {
        this.title = title;
    }

    DayOfWeekEnum(String title, int countCalories) {
        this.title = title;
        this.countCalories = countCalories;
    }

    @Override
    public String toString() {
        return "DayOfWeekEnum{" +
                "title='" + title + '\'' +
                ", countCalories=" + countCalories +
                '}';
    }



    public String getTitle() {
        return title;
    }

    public int getCountCalories() {
        return countCalories;
    }
}
