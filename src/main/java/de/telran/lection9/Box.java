package de.telran.lection9;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Box implements Comparable<Box> {

    private Data data;

    private int count;

    public Box(Data data, int count) {
        this.data = data;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Box{" +
                "data=" + data +
                ", count=" + count +
                '}';
    }

    @Override
    public int compareTo(Box o) {
        // order by data, count
        int result = this.data.compareTo(o.data);
        if (result == 0) {
            result = this.count - o.count;
        }
        return result;
    }


    public static void main(String[] args) {
        List<Box> dataList = Arrays.asList(
                new Box(new Data("abc", 3), 4),
                new Box(new Data("abd", 3), 2),
                new Box(new Data("abc", 3), 6),
                new Box(new Data("abc", 3), 2));

        Collections.sort(dataList);
        for (Box d : dataList){
            System.out.println(d);
        }
    }
}
