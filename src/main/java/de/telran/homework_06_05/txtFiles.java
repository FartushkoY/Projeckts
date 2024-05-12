package de.telran.homework_06_05;

import java.io.*;
import java.util.Scanner;

public class txtFiles {
    public static void main(String[] args) {
        String s;
        while (true) {
            System.out.println("Enter full path ('quit' to exit): ");
            Scanner scanner = new Scanner(System.in);
            s = scanner.nextLine();

            if (s.equals("quit")) break;
            File f = new File(s);
            if (!f.exists()) {
                System.out.println("\nNot found: " + s);
                continue;
            }

            if (!f.isDirectory()) {
                System.out.println("\nNot directory: " + s);
                continue;
            }
            printFile(s);
        }
    }

    private static void printFile(String s) {
        File f = new File(s);
        String[] filesList = f.list();

        for (int i = 0; i < filesList.length; i++) {
            String path = s + File.separator + filesList[i];
            File f1 = new File(path);
            if (f1.isFile()) {
                String fileName = f1.getName();
                if (path.endsWith(".txt")) {
                    try (
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                                    (new FileInputStream(path)))) {
                        System.out.println("File: " + fileName);
                        while (bufferedReader.ready()) {
                            System.out.println(bufferedReader.readLine());
                        }
                    } catch (IOException exception) {
                        System.out.println("Problem with file work " + exception.getMessage());
                    }
                }
            } else {
                printFile(path);
            }
        }
    }
}
