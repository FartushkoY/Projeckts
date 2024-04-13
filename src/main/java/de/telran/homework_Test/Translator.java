package de.telran.homework_Test;

import java.util.*;

public class Translator {


    public static void main(String[] args) {

        Map<String, String> translatorMap = new HashMap<>();
        translatorMap.put("apple", "яблоко");
        translatorMap.put("sleep", "спать");
        translatorMap.put("study", "учиться");
        translatorMap.put("spring", "весна");
        translatorMap.put("table", "стол");
        translatorMap.put("word", "слово");


        Scanner scanner = new Scanner(System.in);
        char inputYesNo;
        do {
            System.out.println("Введите слово");
            String englishWord = scanner.nextLine();
            if (!translatorMap.containsKey(englishWord)) {
                System.out.println("В словаре нет слова " + englishWord);
                System.out.println("Введите перевод слова " + englishWord);
                String translation = scanner.nextLine();
                translatorMap.put(englishWord, translation);
                System.out.println(englishWord + " - " + translatorMap.get(englishWord));
            } else {
                System.out.println(englishWord + " - " + translatorMap.get(englishWord));
            }
            System.out.println("Хотите перевести еще одно слово? (Y/N)");
            inputYesNo = scanner.nextLine().charAt(0);
        } while (inputYesNo == 'Y');
    }
}
