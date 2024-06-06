package de.telran.practice_lesson_23.inner_object;

public class Car implements Runnable {
        private int countLiters = 40;
        private Barrel barrel;
        private int numberThread;

    public Car(Barrel barrel, int numberThread) {
            this.barrel = barrel;
            this.numberThread = numberThread;
        }

        @Override
        public void run() {
            // при такой реализации для решение проблемы "гонки" можно так же использовать
            // синхронизацию внешнего объекта (например: synchronized (barrelGas)) или ReentrantLock
            barrel.minusFuel(countLiters, numberThread);
        }

}
