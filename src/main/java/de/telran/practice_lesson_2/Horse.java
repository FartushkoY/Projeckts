package de.telran.practice_lesson_2;

public class Horse {
    protected String name;
    protected int weight;
    protected int speed;

    public void run() {
        System.out.println(name + " бежит со скоростью "+speed);
    }

    public Horse(String name, int weight, int speed) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
    }

    public Horse() {
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
