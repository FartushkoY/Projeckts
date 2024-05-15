package de.telran.practice_lesson_18;

public class CalculatorLong implements NumeralOperations<Long>{
    @Override
    public Long add(Long a, Long b) {
        return a + b;
    }

    @Override
    public Long sub(Long a, Long b) {
        return a - b;
    }

    @Override
    public Long multi(Long a, Long b) {
        return a * b;
    }

    @Override
    public Long div(Long a, Long b) {
        return a / b;
    }
}
