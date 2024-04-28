package de.telran.lection17;



import de.telran.homeworkComparator.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorExamples {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Tom" , "Jane", "Martin","Tom", "Nik", "Edd", "Jane", "Tom");
        Set<String> uniqueNames = names.stream().collect(Collectors.toSet());

        Map<String, Integer> namesWithLength = names.stream().distinct().collect(Collectors.toMap(name -> name, String::length));
        System.out.println(namesWithLength);

        namesWithLength = names.stream().collect(Collectors.toMap(name -> name, String::length, (length1, length2) -> length1));
        System.out.println(namesWithLength);

        Map<String, Integer>  namesCount = names.stream().collect(Collectors.toMap(name -> name, name -> 1, (el1, el2)-> el1 + el2));
        System.out.println(namesCount);

        //Создать список из экземпляров класса Employee
        Employee employee1 = new Employee("John", "Smith", 32, 176, false, "IT");
        Employee employee2 = new Employee("Sandra", "Bullock", 30, 132, true, "STOK");
        Employee employee3 = new Employee("Jack", "Nicolson", 32, 176, true, "IT");
        Employee employee4 = new Employee("Tom", "White", 19, 88, false, "ACCOUNTING");
        Employee employee5 = new Employee("Jim", "Black", 45, 176, true, "STOCK");
        List<Employee> employeeList = Arrays.asList(employee1, employee2, employee3, employee4, employee5);
        // С помощью коллекторов:
        // Мар <Имя /Employee>
        Map<String, Employee> nameToEmployeeMap = employeeList.stream().collect(Collectors.toMap(Employee::getName, e -> e));
        System.out.println(nameToEmployeeMap);


        // Map <age / количествo>
        Map<Integer, Integer> ageMap = employeeList.stream().collect(Collectors.toMap(Employee::getAge, age -> 1, Integer::sum));
        Map<Integer, Long> ageMap2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));

        System.out.println(ageMap);
        System.out.println(ageMap2);

        // Map <age / список сотрудников>
        Map<Integer, List<Employee>> employeesByAge = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.mapping(e -> e, Collectors.toList())));
        System.out.println(employeesByAge);

        // Map <isActive / количествo>
        Map<Boolean, Long> isActiveMap = employeeList.stream().collect(Collectors.partitioningBy(Employee::isActive, Collectors.counting()));
        System.out.println(isActiveMap);

        // Map <Department / список сотрудников>
        Map<String, List<Employee>> employeesByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(e -> e, Collectors.toList())));


        // Map <Department / общая сумма рабочих часов>
        Map<String, Integer> workingHoursByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getWorkingHoursInMonth)));
        System.out.println(workingHoursByDepartment);

        String string = employeeList.stream().map(Employee::getName).collect(Collectors.joining(", "));
        string = employeeList.stream().map(Employee::getName).reduce((s1, s2) -> s1 + ", " + s2).orElse("");
        System.out.println(string);

    }



}
