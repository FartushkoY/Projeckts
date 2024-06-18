package de.telran.selfWork.thatIsLife;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestLena {

    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder();
//        try (
//                Reader reader = new FileReader("абсолютный путь к файлу");
//                BufferedReader bufferedReader = new BufferedReader(reader);
//        ) {
//           while (bufferedReader.ready()) {
//               stringBuilder.append(bufferedReader.readLine()).append(" ");
//           }
//        } catch (IOException e) {
//            System.out.println("problem with file: " + e.getMessage());
//        }
//        String string = stringBuilder.toString();
        String text = "1;3340939699;123";
        String text2 = "2;3340939699;123";
        String text3 = "3;3340939699;123";
        String[] strings = {text, text2, text3};

        String regex = "\\d;\\d+;([\\d]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String result = matcher.group();
            System.out.println(result);
        }




//        String group = Pattern.compile(regex).matcher(text).results().group(0);
//        System.out.println(group);


    }

}
