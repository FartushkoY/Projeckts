package de.telran.lection20.directories;

import java.io.File;

public class FileExamples {
    public static void main(String[] args) {
        File file = new File("resources/newFile,txt");

        File directory = new File("resourcrs/dir");
        System.out.println(directory.exists());
        directory.mkdir();
        System.out.println(directory.exists());



    }
}