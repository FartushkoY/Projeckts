package de.telran.practice_lesson_3;

public interface IntMove {
    boolean isWings = false;
    default void move() {
        System.out.println("С помощью ног. "+calcSpeed());
    }
    private int calcSpeed() { // c Java 9
        return 20;
    }
}
