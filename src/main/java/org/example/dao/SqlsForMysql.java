package org.example.dao;

public final class SqlsForMysql {

    public SqlsForMysql() {
    }

    public static final String createDatabaseM4L7Sql = "CREATE DATABASE M4L7;";
    public static final String createTableCustomersSql = """
            CREATE TABLE M4L7.customers
                    (
                        id    BIGINT PRIMARY KEY,
                        name  VARCHAR(128),
                        phone INT
                    );
            """;
    public static final String deleteTableCustomersSql = "DROP TABLE IF EXISTS M4L7.customers";

    public static final String insertDataIntoCustomersSql = """
            INSERT INTO M4L7.customers
            VALUES (001, 'Bryan Cranston', 5550666),
                   (002, 'Anna Gunn', 5550667),
                   (003, 'Aaron Paul', 5550669),
                   (004, 'Betsy Brandt', 5550800),
                   (005, 'Mark Margolis', 5550999),
                   (006, 'Dean Norris', 5550543),
                   (007, 'Bob Odenkirk', 5550123),
                   (008, 'Giancarlo Esposito', 5550321),
                   (009, 'Laura Fraser', 5550333);
            """;

    public static final String getAllFromCustomersSql = "SELECT * FROM M4L7.customers";


}
