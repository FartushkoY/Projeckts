package de.telran.lection19;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExampleBufferedReader {
    public static void main(String[] args) throws FileNotFoundException {
        String pathFrom = "D:/Study_Telran/Projeckts/JavaPro3/src/main/java/de/telran/lection19/ExampleFileInputStream.java";
        List<String> strings = new ArrayList<>();
        try {
            // стандартный вид записи:
//            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(pathFrom)));
            InputStream inputStream = new FileInputStream(pathFrom);
            // InputStreamReader convert bytes to char
            Reader reader = new InputStreamReader(inputStream);
            // Buffered - read use buffer
            BufferedReader bufferedReader = new BufferedReader(reader);

            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }

        } catch (IOException exception) {
            System.out.println("Problem with file work " + exception.getMessage());
        }
//        System.out.println("Count lines in file is " + strings.);

    }


}
