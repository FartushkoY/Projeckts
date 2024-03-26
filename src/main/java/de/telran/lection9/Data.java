package de.telran.lection9;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Data implements Comparable<Data> {

    private String stringData;
    private int intData;

    public Data(String stringData, int intData) {
        this.stringData = stringData;
        this.intData = intData;
    }

    @Override
    public String toString() {
        return "Data{" +
                "stringData='" + stringData + '\'' +
                ", intData=" + intData +
                '}';
    }

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

    public int getIntData() {
        return intData;
    }

    public void setIntData(int intData) {
        this.intData = intData;
    }

    @Override
    public int compareTo(@NotNull Data another) {
        // string -> int
        int result = this.stringData.compareTo(another.stringData);
        if (result == 0) {
            result = this.intData - another.intData;
        }
        return result;
    }


    public static void main(String[] args) {
        List<Data> dataList = Arrays.asList(new Data("abc", 3),
                new Data("a", 4),
                new Data("bc", 2),
                new Data("a", 2));

        System.out.println("Natural order");
        Collections.sort(dataList);
        for (Data d : dataList) {
            System.out.println(d);
        }

        System.out.println("Reverse order");
        Collections.sort(dataList, Collections.reverseOrder());
        for (Data d : dataList) {
            System.out.println(d);
        }


    }
}



