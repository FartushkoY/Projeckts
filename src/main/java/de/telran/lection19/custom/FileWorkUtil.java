package de.telran.lection19.custom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

public class FileWorkUtil {

    public static void copy (String from, String to) {
        try {
            FileInputStream fileInputStream = new FileInputStream(from);
            FileOutputStream fileOutputStream = new FileOutputStream(to);
            while (fileInputStream.available() > 0) {
//                int data = fileInputStream.read();
//                fileOutputStream.write(data);
                // или "заинлайнить" переменную
                fileOutputStream.write(fileInputStream.read());
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException exception) {
            System.out.println("Problem with file work " + exception.getMessage());
        }

    }
}
