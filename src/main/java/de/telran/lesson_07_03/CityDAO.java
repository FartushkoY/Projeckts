package de.telran.lesson_07_03;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements WorldDAO<City, Integer> {

    private static final String GET_ALL = "SELECT * FROM city";
    private static final String GET_BY_ID = "SELECT * FROM CITY WHERE city.id = ?";
    private static final String SAVE_CITY = "INSERT INTO city (city.name, city.countryCode, city.population) VALUES (???)";
    private static final String DELETE = "DELETE FROM city WHERE city.id = ?";
    private static final String UPDATE = "UPDATE city SET city.name = 'Amsterdam', city.countryCode = 'NLD', city.population = 1 WHERE city.id = ?";
    private static final String FIND_CITIES_WITH_POPULATION_MORE_THEN = "SELECT * FROM city WHERE city.population >= ? ORDER BY city.population";
    private static final String PRINT_DETAILED_INFO = "SELECT city.id, city.name, city.population, city.countryCode, country.name AS countryName, country.continent FROM city JOIN country ON city.countryCode = country.code WHERE city.id = ? ";

    private ConnectorDB connectorDB = new ConnectorDB();

    @Override
    public List<City> getAll() {
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = connectorDB.makeConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                City city = getCityFromResultSet(resultSet);
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    private City getCityFromResultSet(ResultSet resultSet) throws SQLException {
        City city = new City();
        city.setId(resultSet.getInt("ID"));
        city.setName(resultSet.getString("Name"));
        city.setCountryCode(resultSet.getString("CountryCode"));
        city.setPopulation(resultSet.getInt("Population"));
        return city;
    }


    @Override
    public City getById(Integer id) {
        try (
                Connection connection = connectorDB.makeConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
        ) {
            preparedStatement.setInt(1, id); // 1 - номер аргумента
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            City city = getCityFromResultSet(resultSet);
            return city;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(City city) {
        try (
                Connection connection = connectorDB.makeConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CITY);
        ) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getPopulation());
            preparedStatement.setString(3, city.getCountryCode());
            int updated = preparedStatement.executeUpdate();
            System.out.println("Update sucessfull " + updated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {

        try (Connection connection = connectorDB.makeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        ) {
            preparedStatement.setInt(1, id);
            int delete = preparedStatement.executeUpdate();
            System.out.println("Delete sucessfull " + delete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id) {
        try (
                Connection connection = connectorDB.makeConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        ) {
            if (getById(id) != null) {
                preparedStatement.setInt(1, id);
                int updated = preparedStatement.executeUpdate();
                System.out.println("Update sucessfull " + updated);
            } else {
                System.out.println("Element with id " + id + " non found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void saveSpecialCities() {
        try (
                Connection connection = connectorDB.makeConnection();
                Statement statement = connection.createStatement();
        ) {
//            connection.setAutoCommit(false);
            statement.execute("INSERT INTO city (city.name, city.population, city.countryCode) VALUES ('SpecialCity1', 1, 'USA')");

            Savepoint savepoint = connection.setSavepoint();

            statement.execute("INSERT INTO city (city.name, city.population, city.countryCode) VALUES ('SpecialCity2', 1, 'USA')");
            try {
                System.out.println(1 / 0);
            } catch (ArithmeticException e) {
                connection.rollback(savepoint);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<City> findCitiesWithPopulationMoreThan(Integer population) {
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = connectorDB.makeConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_CITIES_WITH_POPULATION_MORE_THEN);
        ) {
            preparedStatement.setInt(1, population);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                City city = getCityFromResultSet(resultSet);
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }



// Метод работает, но мне сильно кажется, что это костыли))
    public Join printDetailedInfoById(Integer id) {
        try (
                Connection connection = connectorDB.makeConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(PRINT_DETAILED_INFO);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return getDataFromResultSetJoin(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Join getDataFromResultSetJoin(ResultSet resultSet) throws SQLException {
        City city = new City();
        Country country = new Country();
        Join join = new Join(city, country);
        join.getCity().setId(resultSet.getInt("ID"));
        join.getCity().setName(resultSet.getString("Name"));
        join.getCity().setCountryCode(resultSet.getString("CountryCode"));
        join.getCity().setPopulation(resultSet.getInt("Population"));
        join.getCountry().setName(resultSet.getString("countryName"));
        join.getCountry().setContinent(resultSet.getString("Continent"));
        return join;
    }
}
