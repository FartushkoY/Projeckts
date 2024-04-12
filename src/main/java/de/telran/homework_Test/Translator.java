package de.telran.homework_Test;

import java.util.*;

public class Translator {
    private String englishWord;
    private String translation;

    public Translator(String englishWord, String translation) {
        this.englishWord = englishWord;
        this.translation = translation;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getTranslation() {
        return translation;
    }

    @Override
    public String toString() {
        return "Translator{" +
                "englishWord='" + englishWord + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }


    public static void main(String[] args) {
        Translator translator1 = new Translator("apple", "яблоко");
        Translator translator2 = new Translator("sleep", "спать");
        Translator translator3 = new Translator("study", "учиться");
        Translator translator4 = new Translator("spring", "весна");
        Translator translator5 = new Translator("table", "стол");
        Translator translator6 = new Translator("word", "слово");
        List<Translator> list = Arrays.asList(translator1, translator2, translator3, translator4, translator5, translator6);

        Map<String, String> translatorMap = new HashMap<>();
        for (Translator translator : list) {
            translatorMap.put(translator.getEnglishWord(), translator.getTranslation());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово");
        String englishWord = scanner.nextLine();
        getTranslate(translatorMap, englishWord);
        System.out.println(translatorMap);

    }

    private static void getTranslate(Map<String, String> translatorMap, String englishWord) {
        if (translatorMap.containsKey(englishWord)) {
            System.out.println(englishWord + " - " + translatorMap.get(englishWord));
        } else {
            System.out.println("Введите перевод слова " + englishWord);
            Scanner scanner = new Scanner(System.in);
            String translation = scanner.nextLine();
            translatorMap.put(englishWord, translation);
            System.out.println(englishWord + " - " + translatorMap.get(englishWord));
        }

    }

}
