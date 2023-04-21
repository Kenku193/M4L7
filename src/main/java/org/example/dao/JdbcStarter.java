package org.example.dao;

import java.sql.*;

public class JdbcStarter {
    public static void main(String[] args) throws SQLException {

        execute(SqlsForMysql.deleteTableCustomersSql);
        execute(SqlsForMysql.createTableCustomersSql);
        System.out.println(executeUpdate(SqlsForMysql.insertDataIntoCustomersSql));
        printAllFromTable(SqlsForMysql.getAllFromCustomersSql);

    }

    public static void execute(String sqlInstruction) throws SQLException {
        try (Connection connection = getConnection()) {
            System.out.println(connection);
            Statement statement = connection.createStatement();
            statement.execute(sqlInstruction);
        }
    }

    public static int executeUpdate(String sqlInstruction) throws SQLException {
        try (Connection connection = getConnection()) {
            System.out.println(connection);
            Statement statement = connection.createStatement();
            int countModifiedFields = statement.executeUpdate(sqlInstruction);
            return countModifiedFields;
        }
    }

    public static void printAllFromTable(String sqlInstruction) throws SQLException {
        try (Connection connection = getConnection()) {
            System.out.println(connection);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlInstruction);

            while (resultSet.next()){
                long id = resultSet.getLong(1);
                String  name = resultSet.getString(2);
                int phone = resultSet.getInt(3);
                System.out.println(id + " " + name + " " + phone);

            }
        }
    }

    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "qwerty";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
