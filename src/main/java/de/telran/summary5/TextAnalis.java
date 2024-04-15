package de.telran.summary5;

import java.util.*;

public class TextAnalis {
    public static void main(String[] args) {


        String text = "Harry Potter and the Sorcerer's Stone\n" +
                "CHAPTER ONE\nTHE BOY WHO LIVED\n" +
                "Mr. and Mrs. Dursley, of number four, Privet Drive, were proud to say\n" +
                "that they were perfectly normal, thank you very much. They were the last\n" +
                "people you'd expect to be involved in anything strange or mysterious,\n" +
                "because they just didn't hold with such nonsense.\n" +
                "Mr. Dursley was the director of a firm called Grunnings, which made\n" +
                "drills. He was a big, beefy man with hardly any neck, although he did\n" +
                "have a very large mustache. Mrs. Dursley was thin and blonde and had\n" +
                "nearly twice the usual amount of neck, which came in very useful as she\n" +
                "spent so much of her time craning over garden fences, spying on the\n" +
                "neighbors. The Dursleys had a small son called Dudley and in their\n" +
                "opinion there was no finer boy anywhere.\n" +
                "The Dursleys had everything they wanted, but they also had a secret, and\n" +
                "their greatest fear was that somebody would discover it. They didn't\n" +
                "think they could bear it if anyone found out about the Potters. Mrs.\n" +
                "Potter was Mrs. Dursley's sister, but they hadn't met for several years;\n" +
                "in fact, Mrs. Dursley pretended she didn't have a sister, because her\n" +
                "sister and her good-for-nothing husband were as unDursleyish as it was\n" +
                "possible to be. The Dursleys shuddered to think what the neighbors would\n" +
                "say if the Potters arrived in the street. The Dursleys knew that the\n" +
                "Potters had a small son, too, but they had never even seen him. This boy\n" +
                "was another good reason for keeping the Potters away; they didn't want\n" +
                "Dudley mixing with a child like that.\n" +
                "When Mr. and Mrs. Dursley woke up on the dull, gray Tuesday our story\n" +
                "starts, there was nothing about the cloudy sky outside to suggest that\n" +
                "strange and mysterious things would soon be happening all over the\n" +
                "country. Mr. Dursley hummed as he picked out his most boring tie for\n" +
                "work, and Mrs. Dursley gossiped away happily as she wrestled a screaming\n" +
                "Dudley into his high chair.\n" +
                "None of them noticed a large, tawny owl flutter past the window.\n" +
                "At half past eight, Mr. Dursley picked up his briefcase, pecked Mrs.\n" +
                "Dursley on the cheek, and tried to kiss Dudley good-bye but missed,\n" +
                "2\n" +
                "because Dudley was now having a tantrum and throwing his cereal at the\n" +
                "walls. \"Little tyke,\" chortled Mr. Dursley as he left the house. He got\n" +
                "into his car and backed out of number four's drive.\n" +
                "It was on the corner of the street that he noticed the first sign of\n" +
                "something peculiar -- a cat reading a map. For a second, Mr. Dursley\n" +
                "didn't realize what he had seen -- then he jerked his head around to\n" +
                "look again. There was a tabby cat standing on the corner of Privet\n" +
                "Drive, but there wasn't a map in sight. What could he have been thinking\n" +
                "of? It must have been a trick of the light. Mr. Dursley blinked and\n" +
                "stared at the cat. It stared back. As Mr. Dursley drove around the\n" +
                "corner and up the road, he watched the cat in his mirror. It was now\n" +
                "reading the sign that said Privet Drive -- no, looking at the sign; cats\n" +
                "couldn't read maps or signs. Mr. Dursley gave himself a little shake and\n" +
                "put the cat out of his mind. As he drove toward town he thought of\n" +
                "nothing except a large order of drills he was hoping to get that day.\n" +
                "But on the edge of town, drills were driven out of his mind by something\n" +
                "else. As he sat in the usual morning traffic jam, he couldn't help\n" +
                "noticing that there seemed to be a lot of strangely dressed people\n" +
                "about. People in cloaks. Mr. Dursley couldn't bear people who dressed in\n" +
                "funny clothes -- the getups you saw on young people! He supposed this\n" +
                "was some stupid new fashion. He drummed his fingers on the steering\n" +
                "wheel and his eyes fell on a huddle of these weirdos standing quite\n" +
                "close by. They were whispering excitedly together. Mr. Dursley was\n" +
                "enraged to see that a couple of them weren't young at all; why, that man\n" +
                "had to be older than he was, and wearing an emerald-green cloak! The\n" +
                "nerve of him! But then it struck Mr. Dursley that this was probably some\n" +
                "silly stunt -- these people were obviously collecting for something...\n" +
                "yes, that would be it. The traffic moved on and a few minutes later, Mr.\n" +
                "Dursley arrived in the Grunnings parking lot, his mind back on drills.\n" +
                "Mr. Dursley always sat with his back to the window in his office on the\n" +
                "ninth floor. If he hadn't, he might have found it harder to concentrate\n" +
                "on drills that morning. He didn't see the owls swoop ing past in broad\n" +
                "daylight, though people down in the street did; they pointed and gazed\n" +
                "open- mouthed as owl after owl sped overhead. Most of them had never\n" +
                "seen an owl even at nighttime. Mr. Dursley, however, had a perfectly\n" +
                "normal, owl-free morning. He yelled at five different people. He made\n" +
                "several important telephone calls and shouted a bit more. He was in a\n" +
                "very good mood until lunchtime, when he thought he'd stretch his legs\n" +
                "and walk across the road to buy himself a bun from the bakery.";

        String[] words = text.split("\\W+");



        Map<String, Integer> wordMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        for (String s : words) {
            s = s.toLowerCase();
            int count = wordMap.getOrDefault(s, 0);
            wordMap.put(s, count + 1);
        }
        System.out.println(wordMap);
        System.out.println("---------------");
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordMap.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
