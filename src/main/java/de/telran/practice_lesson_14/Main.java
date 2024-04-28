package de.telran.practice_lesson_14;


import java.util.*;
import java.util.stream.Collectors;

//        1. Создать класс Employee с характеристиками:
//        - фамилия, имя, отчество
//        - должность
//        - отдел
//        - зарплата
//        2. Вычислить среднюю зарплату всех сотрудников
//        3. Получить список сотрудников с зп > 1000
//        4*. Получить список сотрудников из отдела маркетинг и увеличить зп на 15%
//        5*. Получить сотрудника с самой низкой зп
//        6*. Получить сотрудника с самой высокой зп
//        7**. Получите сотрудников из всех отделов с максимальной зп
//        8**. Сгрупировать сотрудников по должности
public class Main {
    public static void main(String[] args) {
        Manager manager1 = new Manager("John Smith", "Manager", "Sales Department", 1700.00);
        Manager manager2 = new Manager("Will Black", "Manager", "Procurement Department", 1500.00);
        Manager manager3 = new Manager("Ann White", "Department Head", "Sales Department", 3500.00);
        Manager manager4 = new Manager("Mary Backer", "Manager", "Sales Department", 1500.00);
        Manager manager5 = new Manager("Tom Wilson", "Manager", "Procurement Department", 1800.00);
        Manager manager6 = new Manager("David Davies", "HR-Manager", "HR Department", 1700.00);
        Manager manager7 = new Manager("Mat Jones", "Department Head", "Procurement Department", 3200.00);
        Manager manager8 = new Manager("Sara Davies", "Department Head", "HR Department", 3000.00);

        List<Manager> managerList = Arrays.asList(manager1, manager2, manager3, manager4, manager5, manager6, manager7, manager8);
        managerList.forEach(System.out::println);

        System.out.println("Вычислить среднюю зарплату всех сотрудников");
        OptionalDouble averageSalary = managerList.stream().mapToDouble(Manager::getSalary).average();
        System.out.println(averageSalary);
        System.out.println(averageSalary.getAsDouble());
        System.out.println(averageSalary.orElse(-1));
        System.out.println(averageSalary.isEmpty());
        System.out.println(averageSalary.isPresent());


        System.out.println("Получить список сотрудников с зп > 3000");
        List<Manager> salaryMore3000 = managerList.stream().filter(manager -> manager.getSalary() >= 3000.00).toList();
        System.out.println(salaryMore3000);

//        System.out.println(" Получить список сотрудников из отдела маркетинг и увеличить зп на 15%");
//        List<Manager> salesDistrict = managerList.stream().filter(manager -> manager.getDepartment().startsWith("Sales"))
//                .peek(manager -> manager.setSalary(manager.getSalary() * 1.15)).toList();
//        System.out.println(salesDistrict);

        System.out.println(" Получить список сотрудников из отдела маркетинг " +
                "и вывести увеличенные зп на 15%, не изменяя первоначальных данных. Вывести только суммы ");
        System.out.println(managerList.stream().filter(manager -> manager.getDepartment().startsWith("Sales"))
                .map(manager -> manager.getSalary() * 1.15).toList());


        System.out.println(" Получить список сотрудников из отдела маркетинг " +
                "и вывести увеличенные зп на 15%, не изменяя первоначальных данных. Вывести сотрудников и суммы ");
        System.out.println(managerList.stream().filter(manager -> manager.getDepartment().startsWith("Sales"))
                .map(manager -> new Manager(manager.getName(), manager.getPosition(), manager.getPosition(), manager.getSalary() * 1.15)).toList());


        System.out.println("Получить сотрудника с самой низкой зп");
        System.out.println(managerList.stream().min(Comparator.comparing(Manager::getSalary)));

        System.out.println("Получить сотрудника с самой высокой зп");
        System.out.println(managerList.stream().max(Comparator.comparing(Manager::getSalary)));

        System.out.println("Получить max зп");
        System.out.println(managerList.stream().mapToDouble(Manager::getSalary).max().orElse(-1));

        System.out.println("Получите сотрудников из всех отделов с максимальной зп");
        System.out.println(managerList.stream()
                .collect(Collectors.groupingBy(Manager::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Manager::getSalary)))));

        System.out.println(("Сгрупировать сотрудников по должности"));
        System.out.println(managerList.stream()
                .collect(Collectors.groupingBy(Manager::getPosition)));

        System.out.println("--------");
        Map<String, List<Manager>> groupMap = managerList.stream()
                .collect(Collectors.groupingBy(Manager::getPosition));
        for (Map.Entry entry : groupMap.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("Вывести имена людей, работающих в каждом отделе");
        System.out.println(managerList.stream()
                .collect(Collectors.groupingBy(Manager::getDepartment, Collectors.mapping(Manager::getName, Collectors.toList()))));

        System.out.println(" Вывести имена людей по департаментам одной строкой");
        System.out.println(managerList.stream()
                .collect(Collectors.groupingBy(m -> m.getDepartment(),
                        Collectors.mapping(o -> o.getName(), Collectors.joining(", ", "<",">")))));



        System.out.println(" Вывести обобщенную информацию по департаментам");
        Map<String, DoubleSummaryStatistics> summarizingMap = managerList.stream()
                .collect(Collectors.groupingBy(m -> m.getDepartment(),
                        Collectors.summarizingDouble(Manager::getSalary)));

        System.out.println("Максимальная зп Sales Department: " + summarizingMap.get("Sales Department").getMax());

        System.out.println("Средняя зп Procurement Department: " + summarizingMap.get("Procurement Department").getAverage());


        System.out.println(managerList.stream()
                .collect(Collectors.groupingBy(m -> m.getDepartment(),
                        Collectors.averagingDouble(Manager::getSalary))));

        System.out.println(managerList.stream()
                .collect(Collectors.groupingBy(m -> m.getDepartment(),
                        Collectors.groupingBy(Manager::getPosition))));

        System.out.println(managerList.stream()
                .collect(Collectors.groupingBy(m -> m.getDepartment(),
                        Collectors.groupingBy(Manager::getPosition, Collectors.mapping(Manager::getName, Collectors.toList())))));


    }




}
