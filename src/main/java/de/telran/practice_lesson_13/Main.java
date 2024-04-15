package de.telran.practice_lesson_13;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Consumer<String> task = (s) -> System.out.println(s + ", грузи кирпичи");
        task.accept("Вася");

        task = (s) -> System.out.println(s + ", копай");
        task.accept("Вася");

        List<Consumer<String>> taskDay = new ArrayList<>();
        taskDay.add((s) -> System.out.println(s + ", грузи мусор"));
        taskDay.add((s) -> System.out.println(s + ", носи мешки с цементом"));
        taskDay.add((s) -> System.out.println(s + ", мешай бетон"));

        taskDay.forEach(task1 -> task1.accept("Вася"));

        System.out.println("----");
        taskDay.remove(0);
        taskDay.add(0, new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println(string + ", разгрузи машину с песком");
            }
        });

        taskDay.forEach(task1 -> task1.accept("Вася"));


        job("Вася", s -> System.out.println(s + " шабаш!"));
        job("Вася", new NewJob());

    }

    public static void job(String name, Consumer<String> jobs) {
        System.out.println("Меня зовут " + name);
        jobs.accept(name);
    }



}

class NewJob implements Consumer<String> {

    @Override
    public void accept(String string) {
        System.out.println(string + ", разгрузи гипсокартон");

    }
}
