package de.telran.lection19;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExampleFileOutputStream {

    public static void main(String[] args) {

        String path = "D:/Study_Telran/Projeckts/JavaPro3/src/main/java/de/telran/lection19/fileOut.txt";
        String text = "Text to file";
        String text2 = "Данные для файла";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            char[] chars = text2.toCharArray();
            for (char temp : chars) {
                fileOutputStream.write(temp);
            }
           fileOutputStream.close();
        } catch (IOException exception) {
            System.out.println("we have some problem with file " + exception.getMessage());
        }





    }
}
