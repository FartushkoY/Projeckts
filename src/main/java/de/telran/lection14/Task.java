package de.telran.lection14;

import de.telran.homeworkComparator.Employee;

import java.io.Console;
import java.util.function.*;

public class Task {
    public static void main(String[] args) {
        Supplier<Bot> generateInstanceBot = () -> new Bot();
        Bot bot1 = generateInstanceBot.get();
        System.out.println(bot1);

        Consumer<Integer> printData = (data) -> System.out.println("---" + data + "---");
        printData.accept(123);

        Employee employee1 = new Employee("John", "Smith", 32, 176);
        Predicate<Employee> isAdultEmployee = (data) -> data.getAge() > 18;
        System.out.println(isAdultEmployee.test(employee1));

        int n = 5;
        UnaryOperator<Integer> sum = (number) -> {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                count += i;
            }
            return count;
        };
        System.out.println(sum.apply(n));


    }

    public static class Bot{
        @Override
        public String toString() {
            return "Bot{}";
        }
    }
}
