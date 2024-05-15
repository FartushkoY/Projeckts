package de.telran.summary8;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class LoginError {
    public static void main(String[] args) {

//        2. Имеется некий код, который может выбрасывать Runtime Exception.
//        Реализовать логирование стектрейса Exception со временем ошибки в файл errors.log
        try {
            System.out.println(1 / 0);
        } catch (RuntimeException e) {
            writeLogException(e);
        }

    }

    public static void writeLogException(RuntimeException e) {
        try (
                FileWriter fileWriter = new FileWriter("resources/errors.log");
                PrintWriter printWriter = new PrintWriter(fileWriter);
        )
        {
            Date date = new Date();
            printWriter.print("Error time: " + date + " ");
            e.printStackTrace(printWriter);
        } catch (IOException ignore) {
        }
    }


//    public class ErrorLog {
//
//        public static void whiteLogException(RuntimeException e){
//            try (
//                    FileWriter fileWriter = new FileWriter("errors.log", true);
//                    PrintWriter printWriter = new PrintWriter(fileWriter);)
//            {
//
//                Date currentTime = new Date();
//                printWriter.print("Error: " + currentTime + " ");
//                e.printStackTrace(printWriter);
//
//
//            } catch (IOException ignore) {
//
//            }
//        }
//        public static void main(String[] args) {
//            try {
//                int result = 1 / 0;
//            } catch (RuntimeException e){
//                whiteLogException(e);
//            }
//        }
//    }

}
