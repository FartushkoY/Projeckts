package de.telran.lection14;

import de.telran.homeworkComparator.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortWithLambda {
    public static void main(String[] args) {

        Employee employee1 = new Employee("John", "Smith", 32, 176);
        Employee employee2 = new Employee("Sandra", "Bullock", 30, 132);
        Employee employee3 = new Employee("Jack", "Nicolson", 63, 176);
        Employee employee4 = new Employee("Tom", "White", 32, 88);
        Employee employee5 = new Employee("John", "Smith", 45, 176);

        List<Employee> employeeList = Arrays.asList(employee1, employee2, employee3, employee4, employee5);

        Collections.sort(employeeList, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(employeeList);


//        аналогичная запись
//        Collections.sort(employeeList, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });


    }
}
