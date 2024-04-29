package de.telran.lection19.custom;

public class FileCopyApp {
    public static void main(String[] args) {
//        String pathFrom = "D:/Study_Telran/Projeckts/JavaPro3/src/main/java/de/telran/lection19/custom/fileFromCopy.txt";
        String pathFrom = "D:/Study_Telran/Projeckts/JavaPro3/src/main/java/de/telran/lection19/ExampleFileInputStream.java";
        String pathTo = "D:/Study_Telran/Projeckts/JavaPro3/src/main/java/de/telran/lection19/custom/fileToCopy.txt";
        FileWorkUtil.copy(pathFrom, pathTo);
    }
}
