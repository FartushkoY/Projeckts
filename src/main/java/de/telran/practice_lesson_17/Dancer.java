package de.telran.practice_lesson_17;

public class Dancer extends Actor{


    public Dancer(String name) {
        super(name);
    }

    @Override
    public void showTalant() {
        System.out.println("Dancer " + name + " dances");
    }

    @Override
    public String toString() {
        return "Dancer{" +
                "name='" + name +
                '}';
    }
}
