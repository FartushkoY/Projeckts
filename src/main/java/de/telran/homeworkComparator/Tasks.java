package de.telran.homeworkComparator;

import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", "Smith", 32, 176, true);
        Employee employee2 = new Employee("Sandra", "Bullock", 30, 132, true);
        Employee employee3 = new Employee("Jack", "Nicolson", 63, 176, true);
        Employee employee4 = new Employee("Tom", "White", 32, 88, true);
        Employee employee5 = new Employee("John", "Smith", 45, 176, true);

        List<Employee> employeeList = Arrays.asList(employee1, employee2, employee3, employee4, employee5);
        Collections.sort(employeeList, new Employee.SortByAgeComparator());
        System.out.println("Employees by age");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        System.out.println("Employees by surname and name with anonymus comparator");
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                int result = employee1.getSurname().compareTo(employee2.getSurname());
                if (result == 0) {
                    result = employee1.getName().compareTo(employee2.getName());
                }

                return result;
            }
        });

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }


        System.out.println("Natural order");
        Collections.sort(employeeList);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        System.out.println("getFirstByName " + getFirstByName(employeeList));
        System.out.println("getLastByName " + getLastByName(employeeList));


        System.out.println("Sort by name from z to a");
        Collections.sort(employeeList, new Employee.SortByNameComparator().reversed());
        for (Employee employee :employeeList) {
            System.out.println(employee);
        }

        System.out.println("Sort by working hours and age in reverse order");
        Collections.sort(employeeList, new Employee.SortByAgeComparator().reversed());
        Collections.sort(employeeList, new Employee.SortByworkingHoursComparator().reversed());
        for (Employee employee :employeeList) {
            System.out.println(employee);
        }
        System.out.println("-----------------------");
        Collections.sort(employeeList, new Employee.SortByworkingHoursAndAgeReverseComparator());
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

    }

    private static Employee getFirstByName(List<Employee> employeeList) {
        Employee result = employeeList.get(0);
        for (int i = 0; i < employeeList.size(); i++) {
            if (result.getName().compareTo(employeeList.get(i).getName()) > 0) {
                result = employeeList.get(i);
            }
        }
        return result;
    }

    private static Employee getLastByName(List<Employee> employeeList) {
        Employee result = employeeList.get(0);
        for (int i = 0; i < employeeList.size(); i++) {
            if (result.getName().compareTo(employeeList.get(i).getName()) < 0) {
                result = employeeList.get(i);
            }
        }
        return result;
    }
}
    
    
    
    
    
    

