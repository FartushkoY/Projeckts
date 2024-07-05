package de.telran.lesson_07_03;

import java.sql.*;

public class JdbcConnectionExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");  // в последних версиях идеи это не обязательно

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "1808Marusya2017");
                Statement statement = connection.createStatement();
        ) {

            statement.setFetchSize(5); // определяет, сколько строк полученных из БД будет кешироваться в resultSet
            ResultSet resultSet = statement.executeQuery("select city.name, city.population from city");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

//            System.out.println(resultSet.next());
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + ", ");
                }
                System.out.print("\n");
//                System.out.print(resultSet.getString(1) + " ");
//                System.out.print(resultSet.getString(2) + " ");
//                System.out.print(resultSet.getString(3) + " ");
//                System.out.print(resultSet.getString(4) + " ");
//                System.out.print(resultSet.getString(5) + "/n");
            }
//            resultSet.close(); // автоматически закрывается при закрытии statement
//            statement.close(); // перенести его создание внутрь () блока try, будет закрываться автоматически
//            connection.close();
        }

    }
}
