package de.telran.lection20.exception;

import java.io.*;

public class ExceptionExamples {
    public static void main(String[] args) {

        // unchecked:
        // ArithmeticException
//        int value = 1 / 0;

        // NullPointerException
        String string = null;
//        string.length();

        // ClassCastException
        Object string1 = "value";
//        Integer integer= (Integer) string1;


        // checked
        BufferedReader bufferedReader = null;
        try {
//            InputStream stream = new FileInputStream("resources/somefile.txt");
            Reader reader = new FileReader("resources/somefile.txt");
            bufferedReader = new BufferedReader(reader);

            System.out.println(bufferedReader.readLine());
            bufferedReader.close();
//            throw new IOException("File is corrupted");


        } catch (FileNotFoundException | UnsupportedEncodingException exception) {
//            System.out.println("File not found");
//            System.out.println(exception);
//            System.out.println(exception.getMessage());
//            System.out.println(exception.getCause());
            exception.printStackTrace();
//            throw new RuntimeException("RuntimeException");

        } catch (IOException ex) {
            System.out.println("problem with reading file" + ex.getMessage());
        } finally {
            System.out.println("Actions in finally block");
        }

        System.out.println("Some other action");

        try {
            int value = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("impossible operation");
        }
        System.out.println("Some other actions");



    }

}
