package de.telran.lection14;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UseStringProcessor {
    public static void main(String[] args) {


        StringProcessor makeUpperCase = (s) -> s.toUpperCase();
//        аналогичные записи
        StringProcessor makeUpperCase1 = String::toUpperCase;

        String result = makeUpperCase.process("Hello world!");
        System.out.println(result);
        result = makeUpperCase.process("Data");
        System.out.println(result);

        StringProcessor limit = (s) -> s.substring(0, 3);
        result = limit.process("abcdefgh");
        System.out.println(result);


        StringProcessor stringProcessor = (s) -> {
            String out = "---" + s + "---";
            return out.toUpperCase();
        };

        result = stringProcessor.process("Some data");
        System.out.println(result);

        // void -> result --- Suplier (генератор данных)
        // data -> void  --- Consumer (потребитель данных)
        // data1 -> data2 --- Function --- UnaryOperator
        Function<String, String> upperCaseWithFunction = (s) -> s.toUpperCase();
        result = upperCaseWithFunction.apply("String data");
        System.out.println(result);

        UnaryOperator<String> upperCaseOperator = (s) -> s.toUpperCase();
        result = upperCaseOperator.apply("String data");
        System.out.println(result);





        // (data1, data2) ->data3 --- BiFunction
        // data -> boolean --- Predicate



    }



}

