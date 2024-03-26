package de.telran.summary1;

public class CastExamples2 {

    public static void main(String[] args) {
        int i = 500;

        long j = i;

        byte k = (byte) i;
        System.out.println(k);

        long l = 1000000000000000000L;

        i = (int) l;
        System.out.println(i);
    }


}
