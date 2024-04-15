package de.telran.lection15.functionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CompositionExamples {

    public static void main(String[] args) {
        Consumer<Integer> consumer = (integer -> System.out.println(integer));
        Consumer<Integer> consumer2 = (System.out::println);
        Consumer<Integer> compositeConsumer = consumer.andThen(integer -> System.err.println(integer + 10))
                        .andThen(integer -> System.err.println(integer + 20));

        compositeConsumer.accept(10);
        compositeConsumer.accept(99);


        Predicate<String> isLongEnough = (s) -> s.length() > 3;
        Predicate<String> startsWithS = (s) -> s.startsWith("S");

        Predicate<String> compositePredicate = isLongEnough.negate().and(startsWithS);

        System.out.println(compositePredicate.test("Hello"));
        System.out.println(compositePredicate.test("Summer"));
        System.out.println(compositePredicate.test("Sum"));

        Function<String, String> function1 = s -> s + "1";
        Function<String, String> function2 = s -> s + "2";
        Function<String, String> function3 = s -> s + "3";

        Function<String, String> compoiteFunction = function1.andThen(function2). andThen(function3);
        String result = compoiteFunction.apply("Test data");
        System.out.println(result);

        compoiteFunction = function1.compose(function2).compose(function3);
        result = compoiteFunction.apply("Test data");
        System.out.println(result);

//        1.Создать три функции:
//        - обрезает входную строку до 11 символов,
//                - добавялет текст "Info: " перед
//                - делает основной текст upper case
//                Составить композитную функцию так, чтобы:
//        Input:
//        "Some random data"
//        Output:
//        "Info: SOME RANDOM
        Function<String , String> taskFunction1 = s -> s.substring(0, 11);
        Function<String, String> taskFunction2 = s -> "Info: " + s;
        Function<String, String> taskFunction3 = s -> s.toUpperCase();

        // Возможны разные варианты, как собрать итоговую функцию:

        Function<String, String> compositeTaskFunction = taskFunction1.andThen(taskFunction3).andThen(taskFunction2);
        result = compositeTaskFunction.apply("Some random data");
        System.out.println(result);

        compositeTaskFunction = taskFunction1.compose(taskFunction3).andThen(taskFunction2);
        System.out.println(compositeTaskFunction.apply("Some random data"));


        compositeTaskFunction = taskFunction2.compose(taskFunction3).compose(taskFunction1);
        System.out.println(compositeTaskFunction.apply("Some random data"));


    }
}
