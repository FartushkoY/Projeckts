package de.telran.summary2;

import java.math.BigDecimal;

public class MoneyExample {
    public static void main(String[] args) {
        double sum = 0.0;

        for (int i = 0; i < 10_000; i++) {
            sum += 0.1;
        }

        System.out.println(sum == 1000.0);
        System.out.println(sum);

        BigDecimal bigDecimalSum = new BigDecimal(0);
        for (int i = 0; i < 10000; i++) {
            bigDecimalSum = bigDecimalSum.add(BigDecimal.valueOf(0.1));
//          bigDecimalSum = bigDecimalSum.add(new BigDecimal("0.1"));     // double передаем в BigDecimal в виде строки

        }

        System.out.println(bigDecimalSum.equals(BigDecimal.valueOf(1000)));
        System.out.println(bigDecimalSum.compareTo(BigDecimal.valueOf(1000)));





    }
}
