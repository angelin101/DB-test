package myDBRealisation.DAO.MyDAO;

import myDBRealisation.DAO.CityDAO;
import myDBRealisation.DAO.UserDAO;
import myDBRealisation.User;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ангелин on 09.10.2015.
 */
public class MyUserDAO implements UserDAO {
    private final String queryAddUser;
    private final String queryGetUserByName;
    private final String queryUpdateUserByID;
    private final String quaryRemoveUserByName;
    private final String queryGetAllUser;
    private Connection connection;
    private final MyDAOFactory factory;

    protected MyUserDAO(MyDAOFactory factory){
        queryAddUser = "insert into users(name, age, city) values(?,?,?)";
        queryGetUserByName = "select * from users, city where users.city = city.id_city and users.name = ?";
        queryUpdateUserByID = "update users set name = ?, age = ?, city = ? where id = ?";
        quaryRemoveUserByName = "delete from users where name = ?";
        queryGetAllUser = "select * from users, city where users.city = city.id_city";
        this.factory = factory;
    }

    @Override
    public void addUser(User user) {
        connection = factory.getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(queryAddUser);
            st.setString(1, user.getName());
            st.setInt(2, user.getAge());
            CityDAO cityBD = MyDAOFactory.getCityDAO();
            System.out.println(cityBD.getIDByCityName(user.getCity()));
            st.setInt(3, cityBD.getIDByCityName(user.getCity()));// Также можно сделать свой эксепшен если такого города нет!
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            factory.closeConnection();
        }
    }

    @Override
    public User getUserByName(String userName) {// Можно тоже свой эксепшен если такого имени в базе нет!
        User user = new User();
        connection = factory.getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(queryGetUserByName);
            st.setString(1, userName);
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            user.setCity(resultSet.getString("city_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            factory.closeConnection();
        }
        return user;
    }

    @Override
    public boolean updateUserByID(User user) {
        connection = factory.getConnection();
        // Также можно продумать логику, на случай если такого города в таблице city нет!!!
        try {
            PreparedStatement st = connection.prepareStatement(queryUpdateUserByID);
            st.setString(1, user.getName());
            st.setInt(2, user.getAge());
            CityDAO cityDB = MyDAOFactory.getCityDAO();
            st.setInt(3, cityDB.getIDByCityName(user.getCity()));
            st.setInt(4, user.getId());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            factory.closeConnection();
        }
        return true;
    }

    @Override
    public void removeUserByName(String userName) {
        connection = factory.getConnection();
        // Также можно возвращать булеян что бы было ясно об изменениях!!!
        try {
            PreparedStatement st = connection.prepareStatement(quaryRemoveUserByName);
            st.setString(1, userName);
            st.execute();// Можно сделать через boolean (через executeUpdate() -
            // будет возвращать колличесвто изменений) что бы понимать были ли изменения!!!
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            factory.closeConnection();
        }
    }

    @Override
    public List<User> getAllUser() {
        List<User> listUsers = new LinkedList<>();
        connection = factory.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(queryGetAllUser);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setCity(resultSet.getString("city_name"));
                listUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            factory.closeConnection();
        }
        return listUsers;
    }
}
