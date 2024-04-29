package de.telran.practice_lesson_17;

public abstract class Actor {
     String name;

    public Actor(String name) {
        this.name = name;

    }

    public abstract void showTalant();

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
