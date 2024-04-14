package de.telran.homework_10_04FunctionalInterfaces;

import de.telran.lection5.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> jokes = new ArrayList<>();
        jokes.add("В одесском ресторане висит объявление: \"У нас сменилось руководство\". anekdotov.net,\n" +
                "Один из постоянных клиентов спрашивает:\n" +
                "— А шо, Арон Моисеевич продал таки ресторан?\n" +
                "— Нет, он таки женился.");
        jokes.add("Лайфхак. Если хочешь забрать все призовые игрушки из тира, то целиться нужно не в игрушки.");
        jokes.add("Приходит программист к другу-пианисту – посмотреть на новый рояль. Долго ходит вокруг, хмыкает, потом заявляет:\n" +
                "\n" +
                "- Клава неудобная – всего 84 клавиши, половина функциональных, ни одна не подписана; хотя... шифт нажимать ногой – это оригинально!");
        jokes.add("Есть 10 типов людей: понимающие двоичную систему счисления и не понимающих.");
        jokes.add("- Слушай, ты же программист? Какой язык чаще всего используется программистами?\n" +
                "- Матерный.");
        jokes.add("Давно сменил все свои пароли на «incorrect». Если забываю, cайт напоминает: «Your password is incorrect».");
        jokes.add("— Отправьте мне эти документы по факсу.\n" +
                "— К сожалению, там, где я сейчас нахожусь, факс отправить невозможно.\n" +
                "— А где вы находитесь?\n" +
                "— В 2021-м.");
        jokes.add("Как много о новых возможностях «винды» можно узнать, просто дав клавиатуру маленькому ребенку!\n" +
                "\n");

        Supplier<String> randomJoke = () -> jokes.get(new Random().nextInt(jokes.size()));

        System.out.println(randomJoke.get());
        System.out.println("--------");
        System.out.println(randomJoke.get());
        System.out.println("--------");
        System.out.println(randomJoke.get());
        System.out.println("--------");


        Consumer<Integer> evenOrOdd = (data) -> {
            if (data %2 == 0) System.out.println(data);
            else System.err.println(data);
        };
        evenOrOdd.accept(15);
        evenOrOdd.accept(16);
        evenOrOdd.accept(5);
        evenOrOdd.accept(4);


        Predicate<Cat> isWhiteCat = (cat) -> cat.getColour() == "White";
        System.out.println(isWhiteCat.test(new Cat("Tom", "Gray", 2)));
        System.out.println(isWhiteCat.test(new Cat("Tim", "White", 1)));


        BiFunction<Integer, Integer, Integer> power = (m, n) -> (int)Math.pow(m, n);
        System.out.println(power.apply(5, 2));
        System.out.println(power.apply(2, 5));

    }
}
