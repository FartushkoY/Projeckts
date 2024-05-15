package de.telran.lection20.io;

import java.io.*;

public class WriteFileExamples {
    public static void main(String[] args) {
        File file = new File("resources/newFile.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                Writer writer = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                ){
            bufferedWriter.write("new text 1");
            bufferedWriter.write("new text 2");
            bufferedWriter.write("new text 3");
            bufferedWriter.flush();
            bufferedWriter.write("new text 4");
            bufferedWriter.write("new text 5");
            bufferedWriter.write("new text 6");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }



}
