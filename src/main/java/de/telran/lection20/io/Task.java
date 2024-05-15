package de.telran.lection20.io;

import java.io.*;

public class Task {
    public static void main(String[] args) {
// Записать 3 бита '101' в файл, считать их.

        File file = new File("resources/taskFile.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte b = 0b101;
//        byte b = 5;

        try (OutputStream stream = new FileOutputStream(file)) {
//            stream.write(new byte[]{b});
            stream.write((int) b);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        try (
                InputStream stream = new FileInputStream(file);
        ) {
            System.out.println(stream.read());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

}
