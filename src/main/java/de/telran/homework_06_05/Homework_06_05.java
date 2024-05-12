package de.telran.homework_06_05;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Homework_06_05 {
    public static void main(String[] args) {

        String pathToFile = "resources/somefile.txt";
        File file = new File(pathToFile);
        long length = file.length();

        int lineCount = 0;
        int charCount = 0;

        System.out.println(length + " bytes");
        System.out.println((double) length / 1024 + " Kb");
        System.out.println((double) length / (1024 * 1024) + " Mb");

        try (
                Reader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            while (bufferedReader.ready()) {
                bufferedReader.readLine();
                lineCount++;
            }
        } catch (IOException ex) {
            System.out.println("problem with file: " + ex.getMessage());
        }


        try (
                Reader reader = new FileReader(file);
        ) {
            while (reader.ready()) {
                reader.read();
                charCount++;
            }
        } catch (IOException ex) {
            System.out.println("problem with file: " + ex.getMessage());
        }

        System.out.println("Count lines in file: " + lineCount);
        System.out.println("Count symbols in file: " + charCount);
    }
}
