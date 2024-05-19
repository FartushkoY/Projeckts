package de.telran.lection22;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchInTextExamples {
    public static void main(String[] args) {
        String text = "This is some text. Something other. Some1 other info";
        String regex = "\\b[Ss]ome[a-z]*\\b";
        String regex1 = "\\b[Ss]ome\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern.matcher(text);

        while (matcher.find()) {
            String searchResult = matcher.group();
            System.out.println(searchResult);
            System.out.println("Word found: " + searchResult + "start: " + matcher.start() + " end: " + matcher.end());
        }
        // альтернативная запись через стрим
//        System.out.println("----------");
//        matcher.results().forEach(matchResult -> System.out.println(matchResult.group()));


        while (matcher1.find()) {
            String searchResult1 = matcher1.group();
            System.out.println("Word found: " + searchResult1 + "start: " + matcher1.start() + " end: " + matcher1.end());
        }

        text = "The dog says meaow. All dogs say meaow.";
        regex = "meaow";
        String replacement = "gav";
        String texReplaced = Pattern.compile(regex).matcher(text). replaceAll(replacement);
        System.out.println(texReplaced);

    }
}
