package ua.kharkiv.sourceit.angelin.jdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Ангелин on 30.09.2015.
 */

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "aass8885";

    public static void main(String[] args) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = connection.createStatement()){
            //statement.execute("INSERT INTO mydbtest.users(age,name,email) VALUES(56, 'Lena', 'lena@tvar.com')");
            //int res = statement.executeUpdate("UPDATE users SET age=24 WHERE name='Lena'");
            //ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            //statement.addBatch("INSERT INTO users(name, age, email) VALUE('Anton', 31, 'q@ru') ");
            //statement.addBatch("INSERT INTO users(name, age, email) VALUES ('Marina', 25, 'we@com') ");
            //statement.addBatch("INSERT INTO users(name, age, email) VALUES ('Alexander', 26, 'as@net')");
            //statement.clearBatch();
            //statement.executeBatch();

            System.out.println(connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
