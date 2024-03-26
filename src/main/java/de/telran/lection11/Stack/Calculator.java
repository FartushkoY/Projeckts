package de.telran.lection11.Stack;

import java.util.Stack;

public class Calculator {

    // (1 + 3) * 2 * (2 +5)

    // (2 + 3) * 4 ----> обратная польская запись 2 3 + 4 * (сначала аргументы, потом действия)
    // 1 + 2 * 3 ----->  1 2 3 * +
    // (3 + 4) * (5 + 6) ----> 3 4 + 5 6 + *
    // (1 * 3 * 5 + 2 * (1 + 8 * 2)) ----> 1 3 5 * * 2 1 8 2 * + * +

    public static void main(String[] args) {
        int result = calculate("2 3 + 4 *");
        System.out.println(result);

        System.out.println(calculate("1 2 3 * +"));
        System.out.println(calculate("3 4 + 5 6 + *"));
        System.out.println(calculate("1 3 5 * * 2 1 8 2 * + * +"));
    }

    private static int calculate(String string) {
        String[] elements = string.split(" ");
        Stack<Integer> numbers = new Stack<>();
        for (String element : elements) {
            if (element.equals("*")) {
                Integer second = numbers.pop();
                Integer first = numbers.pop();
                numbers.push(first * second);
            } else if (element.equals("+")) {
                Integer second = numbers.pop();
                Integer first = numbers.pop();
                numbers.push(second + first);
            } else {
                Integer number = Integer.valueOf(element);
                numbers.push(number);
            }
        }
        return numbers.pop();
    }
}
