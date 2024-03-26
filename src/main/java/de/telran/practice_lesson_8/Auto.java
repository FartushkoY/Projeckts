package de.telran.practice_lesson_8;

public class Auto implements Comparable<Auto>{
    private String number;
    private String name;
    private int manufactureYear;

    public Auto(String number, String name, int manufactureYear) {
        this.number = number;
        this.name = name;
        this.manufactureYear = manufactureYear;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", manufactureYear=" + manufactureYear +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    @Override
    public int compareTo(Auto o) {
        return this.name.compareTo(o.name);
    }
}
