package de.telran.lection19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExampleFileInputStream {
    public static void main(String[] args) {
        String path = "D:/Study_Telran/Projeckts/JavaPro3/src/main/java/de/telran/lection19/file.txt";

        // ->H E L L O read
        // H ->E L L O read
        // H E ->L L O read
        //...
        // H E L L O -> read

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            int data = fileInputStream.read();
            while (data != -1) {
                System.out.print(data + " ");
                data = fileInputStream.read();
            }
            //  если файл уже прочитан (стрим был запущен), то второй код не выполнится.
            //  Чтобы прочитать файл снова, нужно пересоздать стрим заново

            // аналогичная запись
            while (fileInputStream.available() > 0) {
                System.out.print((char) fileInputStream.read() + " ");
            }

//            System.out.println((char) data);
//
//            data = fileInputStream.read();
//            System.out.println((char) data);
//
//            data = fileInputStream.read();
//            System.out.println((char) data);


//        } catch (FileNotFoundException exception) {
//            System.out.printf("File with path %s not found please try again", path);
//        } catch (IOException exception) {
//            System.out.println("Problem with access to file " + exception.getMessage());
//        }
            fileInputStream.close();
        }catch (IOException exception) {
            System.out.println("we have some problem with file " + exception.getMessage());
        }

        System.out.println("\nend of application");



    }
}
