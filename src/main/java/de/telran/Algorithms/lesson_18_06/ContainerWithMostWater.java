package de.telran.Algorithms.lesson_18_06;

public class ContainerWithMostWater {
    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(getMaxAmountWater(height));
    }

    private static int getMaxAmountWater(int[] height) {
        int maxAmountWater = 0;
        int amountWater = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] <= height[j]) {
                    amountWater = height[i] * (j - i);
                } else {
                    amountWater = height[j] * (j - i);
                }
                    maxAmountWater = Math.max(maxAmountWater, amountWater);
            }
        }
        return maxAmountWater;
    }
}

//    Дано целое число height длины n. Проведено n вертикальных линий так,
//    что две конечные точки i-й линии - (i, 0) и (i, height[i]).
//    Найдите две прямые, которые вместе с осью x образуют контейнер, содержащий наибольшее количество воды.
//    Верните максимальное количество воды, которое может вместить контейнер.
//    Обратите внимание, что контейнер нельзя наклонять.