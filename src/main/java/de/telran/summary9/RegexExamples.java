package de.telran.summary9;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {
    public static void main(String[] args) {
        String text = "one cat hello world\n" +
                "oneA cat two three\n" +
                "four five\n" +
                "world one hello";

        Pattern pattern = Pattern.compile("^one|[\\s]one");
        Matcher matcher = pattern.matcher(text);
        matcher.results().forEach(matchResult -> System.out.println(matchResult.group()));

        text = "input: 123-123, input: 321-321, input: 44444-2522532";
        pattern = Pattern.compile("input: (\\d+)-(\\d+)");
        matcher = pattern.matcher(text);
        matcher.results().forEach(matchResult -> System.out.println(matchResult.group() +
                ", group1: " + matchResult.group(1) +
                ", group2: " + matchResult.group(2)));

        text = "777 sone text 777 dfbkad k sdk 545 lflel 888 dshjbbn. 55 888";
        String text1 = "<some text> 777 dfbkad k sdk 545 lflel 888 dshjbbn. 55 888";
        pattern = Pattern.compile("(\\d{3})(.*)\\1");
        Pattern pattern1 = Pattern.compile("<(.*)>");
        matcher = pattern.matcher(text);
        Matcher matcher1 = pattern1.matcher(text1);
        matcher.results().forEach(matchResult -> System.out.println(matchResult.group() + ", extracted text between: " + matchResult.group(2)));
        matcher1.results().forEach(matchResult -> System.out.println(matchResult.group(1)));


        System.out.println("text".matches(".*"));
        System.out.println("text".replaceAll("t", "p"));
        String[] split = "text".split("");
        System.out.println(Arrays.toString(split));




    }


}


