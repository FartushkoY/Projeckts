package de.telran.practice_lesson_23.inner_object;

public class Barrel {
    private int capacity; //вместимость бака
    private int balance; //остаток топлива

    public Barrel(int capacity) {
        this.capacity = capacity;
    }

    public Barrel(int capacity, int balance) {
        this.capacity = capacity;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public int addFuel(int count) {
        if(count+balance > capacity) {
            System.out.printf("В бочку емкостью %d не могу долить еще %d, т.к. текущий остаток - %d", capacity, count, balance);
        }
        else {
            balance+=count;
        }
        return balance;
    }

    // при такой реализации можно использовать synchronized для метода minusFuel для решения проблемы "гонки"
    public /*synchronized*/ int minusFuel(int count, int numberAuto) {
        //Проверяем хватит ли нам топлива на остатке, чтобы выполнить операцию забора с бочки топлива
        if(balance - count < 0) {
            System.err.printf("! Не могу заправить авто %d количеством %d, т.к. текущий остаток = %d%n", numberAuto, count, balance);
            return -1;
        } else {
            System.out.printf("- Мы можем заправить авто %d количеством %d, т.к. текущий остаток = %d%n", numberAuto, count, balance);
        }
        // Иммитируем задержку между проверкой доступности топлива и фактической запроавкой
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        balance-=count;
        System.out.printf("Авто %d заправлен количеством %d, остаток в бочке после заправки = %d%n", numberAuto, count, balance);

        return balance;
    }
}
