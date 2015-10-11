package myDBRealisation.DAO.MyDAO;

import myDBRealisation.DAO.CityDAO;
import myDBRealisation.DAO.DAOFactory;
import myDBRealisation.DAO.UserDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ангелин on 10.10.2015.
 *
 * Обращение к ДАОклассам извне происходит через интерфейсы и статические методы getUserDAO
 * и getCityDAO, остальные методы и логика скрыты от пользователя(получение соединения к БД
 * и его закрытие и т.д.)!!! Конструкторы ДАОклассов приватные и протектед, что бы нельзя было
 * создать обьекты этих классов в обход статическим вышеперечисленным методам!!!
 * В случае изменения логики реализации интерфейсов UserDAO и CityDAO внутри меняеться только
 * реализация статических методов, для пользователя интерфейс получения реализованых классов
 * не меняеться, т.е. пользователь даже не знает какая реализация используеться для получения
 * нужных обьектов!!!
 */
public class MyDAOFactory implements DAOFactory {
    private final String URL;
    private final String USER;
    private final String PASSWORD;
    private Connection conn;

    private MyDAOFactory(){
        URL = "jdbc:mysql://localhost:3306/mydbtest";
        USER = "root";
        PASSWORD = "aass8885";
    }

    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            if (conn != null) {
                closeConnection();
            }
            e.printStackTrace();
        }
        return conn;
    }


        public static UserDAO getUserDAO () {
            MyDAOFactory factory = new MyDAOFactory();
            MyUserDAO myUserDAO = new MyUserDAO(factory);
            return myUserDAO;
        }

        public static CityDAO getCityDAO () {
            MyDAOFactory factory = new MyDAOFactory();
            MyCityDAO myCityDAO = new MyCityDAO(factory);
            return myCityDAO;
        }

        @Override
        public void closeConnection() {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
