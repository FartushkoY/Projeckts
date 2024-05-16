package de.telran.homework_15_05_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        1) Напишите регулярное выражение, которое соответствует любому номеру телефона согласно формату:
//        телефонный номер состоит из 7 цифр подряд или из 3х цифр, пробела или тире,
//        а затем из 4 цифр (1234567, 123-4567, 123 4567).

        String regex = "\\d{7}|\\d{3}[-\\s]\\d{4}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("123-4567");
        boolean matches = matcher.matches();
        System.out.println(matcher.matches());

//        2) Имеется текст "Php is the best programming language in the world. I study php."
//        Замените в нем php на java.


        // правильно ли я понимаю, что одним действием не обойтись,
        // когда нужно заменить и слова с маленькой, и с большой буквы?
        // Точнее, можно, но тогда начало предложения будет с меленькой буквы
        String text = "Php is the best programming language in the world. I study php.";
        regex = "php";
        String replacement = "java";
        String texReplaced = Pattern.compile(regex).matcher(text).replaceAll(replacement);
        regex = "Php";
        replacement = "Java";
        texReplaced = Pattern.compile(regex).matcher(text).replaceAll(replacement);
        System.out.println(texReplaced);

//        3) Имеется некоторый текст. Найти и вывести из него все группы гласных, стоящие вместе.
//        Например: a, ua, uiy

        text = "Shen you search for data in a text, you can use this search pattern to describe what you are searching for.";
        regex = "[aeiou]+";
        Pattern.compile(regex).matcher(text).results().forEach(vowel -> System.out.println(vowel.group()));


//        4) Напишите метод поиска в тексте всех слов, начинающихся с определенной буквы.
        char letter = 's';
        findWords(text, letter);

    }

    private static void findWords(String text, char letter) {
        String regex = "(^[" + letter + "][a-zA-Z]*)|(\\s[Ss][a-zA-Z]*)";
        Pattern.compile(regex).matcher(text.toLowerCase()).results().forEach(word -> System.out.println(word.group()));
    }
}
