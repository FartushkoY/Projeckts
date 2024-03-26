package de.telran.practice_lesson_4.singleton;

public class SimpleSingleton {
    public static void main(String[] args) {
        //классическая (устаревшая) схема Singleton
        Singleton s1 = Singleton.getINSTANCE();
        System.out.println(s1);

        Singleton s2 = Singleton.getINSTANCE();
        System.out.println(s2);

//        enum схема Singleton

        SingletonEnum s3 = SingletonEnum.INSTANCE.getInstance();
        System.out.println(s3.hashCode());
        SingletonEnum s4 = SingletonEnum.INSTANCE.getInstance();
        System.out.println(s4.hashCode());


    }
}
