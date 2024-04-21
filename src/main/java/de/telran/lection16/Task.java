package de.telran.lection16;

import de.telran.homeworkComparator.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Task {




    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");

        //    1. Отсортировать с помощью стримов список из строк
        //- по алфавиту
        //- в обратном порядке
        List<String> sortedList = stringList.stream().sorted().toList();
        System.out.println(sortedList);
        List<String> sortedReverseOrderList = stringList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedReverseOrderList);

        //2. Из списка чисел типа Integer с помощью стримов создать список их строковых представлений
        List<Integer> integers = Arrays.asList(1, 2, 5, 7, 12, 10);
        List<String> stringList1 = integers.stream().map(Object::toString).toList();
        System.out.println(stringList1);


        //    3. Создать список из экземпляров класса Employee. С помощью стримов:
        //          - вывести список активных сотрудников старше 20 лет
        //          - вывести список сотрудников, работающих более 30 часов, с именем, начинающимся на J
        //          - вывести список фамилий сотрудников с именем John
        //          - вывести список всех уникальных имен сотрудников

        Employee employee1 = new Employee("John", "Smith", 32, 176, false);
        Employee employee2 = new Employee("Sandra", "Bullock", 30, 132, true);
        Employee employee3 = new Employee("Jack", "Nicolson", 63, 176, true);
        Employee employee4 = new Employee("Tom", "White", 19, 88, false);
        Employee employee5 = new Employee("John", "Black", 45, 176, true);

        List<Employee> employeeList = Arrays.asList(employee1, employee2, employee3, employee4, employee5);
        List<Employee> employeesActive20 = employeeList.stream().filter(e -> e.isActive() && e.getAge() > 20).toList();
        System.out.println(employeesActive20);

        List<Employee> employees30J = employeeList.stream().filter(e -> e.getWorkingHoursInMonth() > 30 && e.getName().startsWith("J")).filter(e -> e.getName().startsWith("J")).toList();
        System.out.println(employees30J);

        List<String> employeesWithNameJohn = employeeList.stream().filter(employee -> employee.getName().startsWith("John")).map(Employee::getSurname).toList();
        System.out.println(employeesWithNameJohn);

        List<String> employeesNames = employeeList.stream().map(Employee::getName).distinct().toList();
        System.out.println(employeesNames);




    }

}
