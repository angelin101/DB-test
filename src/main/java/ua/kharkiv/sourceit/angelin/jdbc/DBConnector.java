package ua.kharkiv.sourceit.angelin.jdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ангелин on 30.09.2015.
 */
public class DBConnector {
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final String USER = "root";
    private final String PASSWORD = "aass8885";
    private Connection connection;
    public DBConnector(){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
