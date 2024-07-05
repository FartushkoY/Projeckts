package de.telran.lesson_07_03;

import java.util.List;

public class WorldApp {

    public static void main(String[] args) {
        CityDAO cityDAO = new CityDAO();

        City city = cityDAO.getById(10);
        System.out.println(city);

//        City newCity = new City(231431, "Dream City", "USA", 1);
//        cityDAO.save(newCity);

//        cityDAO.saveSpecialCities();

//        cityDAO.delete(3);
//        cityDAO.delete(1);


        System.out.println(cityDAO.getById(5));
        cityDAO.update(5);
        System.out.println(cityDAO.getById(5));
//        List<City> cities = cityDAO.getAll();
//        cities.forEach(System.out::println);
        System.out.println();
        System.out.println("----------------");

        List<City> citiesWithPopulationMoreThan = cityDAO.findCitiesWithPopulationMoreThan(1_000_000);
        citiesWithPopulationMoreThan.forEach(System.out::println);

        Join cityDetailedInfo = cityDAO.printDetailedInfoById(10);
        System.out.println(cityDetailedInfo);


    }
}
