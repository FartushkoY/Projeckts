package de.telran.lection22;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {
    public static void main(String[] args) {
        String text = "words";
        String regex = "word.";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((text));
        boolean matches = matcher.matches();
        System.out.println(matches);

        System.out.println(Pattern.matches("word\\.", "words"));
        System.out.println(Pattern.matches("[ws]ords", "words"));
        System.out.println(Pattern.matches("[ws?]ords", "sords"));
        System.out.println(Pattern.matches("[ws?]ords", "s?ords"));
        System.out.println(Pattern.matches("[ws?]ord[a-e]", "wordc"));
        System.out.println(Pattern.matches("word[12][0-5]", "word12"));
        System.out.println(Pattern.matches("word[^-?!]", "word?"));
        System.out.println(Pattern.matches("word[^-?!]", "word?"));

        System.out.println(Pattern.matches("word[-?!]{3}", "word!?!"));
        System.out.println(Pattern.matches("word[-?!]?", "word!"));
        System.out.println(Pattern.matches("word[-?!]?", "word"));
        System.out.println(Pattern.matches("word[-?!]*", "word"));
        System.out.println(Pattern.matches("word[-?!]*", "word!"));
        System.out.println(Pattern.matches("word[-?!]*", "word!"));
        System.out.println(Pattern.matches("word[-?!]+", "word"));
        System.out.println(Pattern.matches("word[s]?", "word"));
        System.out.println(Pattern.matches("word[s]?", "words"));

        System.out.println(Pattern.matches("[\\w]{5}", "words"));
        System.out.println(Pattern.matches("[\\w]{5}", "12345"));
        System.out.println(Pattern.matches("[\\w]{5}", "1234?"));
        System.out.println(Pattern.matches("[\\s]{5}", "     12345"));
        System.out.println(Pattern.matches("[\\s]{5}", "12345"));
        System.out.println(Pattern.matches("[\\s]{5}", "    \n"));

        System.out.println(Pattern.matches("(cat)|(dog)", "cat"));
        System.out.println(Pattern.matches("(cat)&(dog)", "dog"));

        String someText = "text";
        System.out.println(someText.matches("tex."));




//        if(condition1() || condition2())
//            System.out.println("condition1() || condition2()");
//        if(condition1() | condition2())
//            System.out.println("condition1() || condition2()");
//        if(condition1() && condition2())
//            System.out.println("condition1() || condition2()");
//        if(condition1() & condition2())
//            System.out.println("condition1() || condition2()");




    }

}
