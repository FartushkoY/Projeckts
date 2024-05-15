package de.telran.lection20.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InaccessibleObjectException;

public class ReadFileExamples {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            Reader reader = new FileReader("resources/somefile.txt");
            bufferedReader = new BufferedReader(reader);

            System.out.println(bufferedReader.readLine());
        } catch (IOException ex) {
            System.out.println("problem with file: " + ex.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Problem with closing file");
                }
            }
        }


        // try-with-resources (при таком варианте блок finally не нужен)

        try (
                Reader reader2 = new FileReader("resources/somefile.txt");
                BufferedReader bufferedReader2 = new BufferedReader(reader2);
        ) {
            // read from file

            System.out.println(bufferedReader2.readLine());
        } catch (IOException ex) {
            System.out.println("problem with file: " + ex.getMessage());
        }


    }

}
