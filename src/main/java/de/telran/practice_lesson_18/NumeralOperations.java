package de.telran.practice_lesson_18;

public interface NumeralOperations <T extends Number> {
    T add(T a, T b);
    T sub(T a, T b);
    T multi(T a, T b);
    T div(T a, T b);
}
