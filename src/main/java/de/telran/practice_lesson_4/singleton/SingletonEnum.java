package de.telran.practice_lesson_4.singleton;

public enum SingletonEnum {

    INSTANCE("Initial class info");
    private String info;

    SingletonEnum(String info) {
        this.info = info;
    }

    public SingletonEnum getInstance() {
        return INSTANCE;
    }
}
