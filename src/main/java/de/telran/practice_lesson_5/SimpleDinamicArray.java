package de.telran.practice_lesson_5;

public class SimpleDinamicArray {

    public static void main(String[] args) {
        DynamicIntArray arr1 = new DynamicIntArray();
        System.out.println(arr1);
        for (int i = 0; i < 30; i++) {
            arr1.add(i+1);
        }
        System.out.println(arr1);

        System.out.println();
        DynamicIntArray arr2 = new DynamicIntArray(30);
        System.out.println(arr2);
        for (int i = 0; i < 30; i++) {
            arr2.add(i+1);
        }
        System.out.println(arr2);
        arr2.add(100);
        System.out.println(arr2);

        // Добавление массива
        System.out.println(arr1);
        int[] arrAdd = {55,66,77,88,99};
        arr1.add(arrAdd);
        System.out.println(arr1);

        // Удаление элемента
        arr1.delete(10);
        System.out.println(arr1);

        // Вставка элемента
        arr1.insert(6,99);
        System.out.println(arr1);

        // Получение элемента по индексу
        System.out.println(arr1.getElem(12));

    }
}
