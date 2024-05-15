package de.telran.practice_lesson_20;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Dictionary {
    public static void main(String[] args) {

//        Разбить текст на слова с помощью шаблона регулярного выражения и расчитать
//        словарь встречающихся слов для этого текста
//        (подсчитать количество одинаковых слов, встречающихся в этом тексте).


        String text = "A regular expression is a sequence of characters that forms a search pattern.\n" +
                "When you search for data in a text, you can use this search pattern to describe what you are searching for.\n" +
                "A regular expression can be a single character, or a more complicated pattern.\n" +
                "Regular expressions can be used to perform all types of text search and text replace operations.";



        String regex = "\\w+\\W";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        Map<String, Long> dictionary = new TreeMap<>();
//        int counter = 0;
        while (matcher.find()) {
            String searchResult = matcher.group().toLowerCase();
            if (!dictionary.containsKey(searchResult)) {
                dictionary.put(searchResult, 1L);
            } else {
                Long counter = dictionary.get(searchResult);
                dictionary.put(searchResult, counter + 1);
            }
        }

        int wordCount = 0;
        Map<String, Integer> dictionary2 = new TreeMap<>();
      while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            dictionary2.put(word, dictionary2.getOrDefault(word, 0) + 1);
        }
        System.out.println("Словарь встречающихся слов: ");
//
//        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$

        System.out.println(dictionary);

        String[] matches = Pattern.compile("\\w+\\W")
                .matcher(text)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
        dictionary = pattern.matcher(text).results().map(w -> w.group().toLowerCase()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(dictionary);
    }


}
