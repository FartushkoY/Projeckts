package de.telran.practice_lesson_17;

public class Singer extends Actor{


    public Singer(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public void showTalant() {
        System.out.println("Singer " + name + " sings");
    }

    public void eat() {
        System.out.println(name + " eats");
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                '}';
    }
}
