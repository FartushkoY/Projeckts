package de.telran.practice_lesson_4.singleton;

public class Singleton {

    private static Singleton INSTANCE;
    private String info = "Initial info class";

    private Singleton(){
    }

    public static Singleton getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
