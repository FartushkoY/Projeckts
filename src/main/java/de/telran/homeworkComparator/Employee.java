package de.telran.homeworkComparator;



import java.util.Comparator;

public class Employee implements Comparable<Employee> {
    private String name;
    private String surname;
    private int age;
    private int workingHoursInMonth;
    private boolean isActive;
    private String department;

    public Employee(String name, String surname, int age, int workingHoursInMonth, boolean isActive) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workingHoursInMonth = workingHoursInMonth;
        this.isActive = isActive;
    }

    public Employee(String name, String surname, int age, int workingHoursInMonth, boolean isActive, String department) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workingHoursInMonth = workingHoursInMonth;
        this.isActive = isActive;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", workingHoursInMonth=" + workingHoursInMonth +
                '}';
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public int compareTo(@NotNull Employee another) {
        // c) - natural order by name, surname, age, workingHoursInMonth - Comparable
        int result = this.name.compareTo(another.name);
        if (result == 0) {
            result = this.surname.compareTo(another.surname);
        }
        if (result == 0) {
            result = this.age - another.age;
        }
        if (result == 0) {
            result = this.workingHoursInMonth - another.workingHoursInMonth;
        }
        return result;
    }


    public static class SortByAgeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee employee1, Employee employee2) {
            return Integer.compare(employee1.age, employee2.age);
        }
    }

    public static class SortByworkingHoursComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee employee1, Employee employee2) {
            return Integer.compare(employee1.workingHoursInMonth, employee2.workingHoursInMonth);
        }
    }


    public static class SortByNameComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee employee1, Employee employee2) {
            return employee1.name.compareTo(employee2.name);
        }
    }

    public static class SortByworkingHoursAndAgeReverseComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee employee1, Employee employee2) {
            int result = employee2.workingHoursInMonth - employee1.workingHoursInMonth;
            if (result == 0) {
                result = employee2.age - employee1.age;
            }
            return result;
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getWorkingHoursInMonth() {
        return workingHoursInMonth;
    }
}
