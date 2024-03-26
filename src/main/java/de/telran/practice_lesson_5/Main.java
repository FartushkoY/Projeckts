package de.telran.practice_lesson_5;

public class Main {
    public static void main(String[] args) {
        CopyDynamicIntArray arr3 = new CopyDynamicIntArray();
        System.out.println(arr3);
        for (int i = 0; i < 30; i++) {
            arr3.add(i+1);
        }
        System.out.println(arr3);

        System.out.println();
        CopyDynamicIntArray arr4 = new CopyDynamicIntArray(30);
        System.out.println(arr4);
        for (int i = 0; i < 30; i++) {
            arr4.add(i+1);
        }
//        System.out.println(arr2);
//        arr2.add(100);
//        System.out.println(arr2);

        // Добавление массива
        System.out.println("---------------------------");
        System.out.println(arr3);
        int[] arrAdd = {55,66,77,88,99};
        arr3.add(arrAdd);
        System.out.println(arr3);

        // Удаление элемента
        arr3.delete(10);
        System.out.println(arr3);

        // Вставка элемента
        arr3.insert(6,99);
        System.out.println(arr3);

        // Получение элемента по индексу
        System.out.println(arr3.getElem(12));
    }
}
