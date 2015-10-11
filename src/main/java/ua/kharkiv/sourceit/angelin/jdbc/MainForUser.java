package ua.kharkiv.sourceit.angelin.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ангелин on 30.09.2015.
 */
public class MainForUser {
    public static void main(String[] args) {
        DBConnector connector = new DBConnector();
        Statement statement;
        String quary = "select * from users";
        List<User> list = new LinkedList<>();
        try {
            statement =  connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(quary);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connector.getConnection().close();
            } catch (SQLException e) {
            }
        }
        for (User u : list){
            System.out.println(u);
        }
    }
}
