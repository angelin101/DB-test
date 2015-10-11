package myDBRealisation.DAO.MyDAO;

import myDBRealisation.City;
import myDBRealisation.DAO.CityDAO;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ангелин on 07.10.2015.
 */

public class MyCityDAO implements CityDAO {
    private final String queryAddCity;
    private final String queryGetCityByName;
    private final String queryRemoveCityByName;
    private final String queryGetAllCity;
    private final String queryUpdateCity;
    private final String queryGetIDByCityName;
    private final MyDAOFactory factory;
    private Connection connection;

    protected MyCityDAO(MyDAOFactory factory){
        queryAddCity = "insert into mydbtest.city(city_name, country) values(?, ?)";
        queryGetCityByName = "select * from mydbtest.city where city_name=?";
        queryRemoveCityByName = "delete from mydbtest.city where city_name=?";
        queryGetAllCity = "select * from mydbtest.city";
        queryUpdateCity = "update mydbtest.city set city_name=?, country=? where id_city=?";
        queryGetIDByCityName = "select id_city from city where city_name = ?";
        this.factory = factory;
    }

    @Override
    public void addCity(City city) {
        connection = factory.getConnection();
        try {
            connection.setAutoCommit(false);// Начало блока транзакции!
            PreparedStatement st = connection.prepareStatement(queryAddCity);
            st.setString(1, city.getNameCity());
            st.setString(2, city.getCountry());
            st.executeUpdate();// ??????????? Точно этим завершать???
            connection.commit();// Конец блока транзакции!
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            factory.closeConnection();
        }
    }

    @Override
    public City getCityByName(String nameCity) {
        City city = new City();
        connection = factory.getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(queryGetCityByName);
            st.setString(1, nameCity);
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            city.setIdCity(resultSet.getInt("id_city"));
            city.setNameCity(resultSet.getString("city_name"));
            city.setCountry(resultSet.getString("country"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            factory.closeConnection();
        }
        return city;
    }

    @Override
    public boolean updateCityByID(City city) {
        connection = factory.getConnection();
        try {
            connection.setAutoCommit(false); // Блок транзакции открыт
            PreparedStatement st = connection.prepareStatement(queryUpdateCity);
            st.setString(1, city.getNameCity());
            st.setString(2, city.getCountry());
            st.setInt(3, city.getIdCity());
            st.executeUpdate(); // ???????????
            connection.commit();// Блок транзакции закрыт
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
    public void removeCityByName(String nameCity) {
        connection = factory.getConnection();
        // Продумать логику удаления если данный город есть таблице users!!!
        try {
            connection.setAutoCommit(false);
            PreparedStatement st = connection.prepareStatement(queryRemoveCityByName);
            st.setString(1, nameCity);
            st.execute();// НУЖНО ЛИ???
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            factory.closeConnection();
        }
    }

    @Override
    public int getIDByCityName(String nameCity) {
        int result = 0;
        connection = factory.getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(queryGetIDByCityName);
            st.setString(1, nameCity);
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            result = resultSet.getInt("id_city");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            factory.closeConnection();
        }
        return result;// Можно свой эксепшен сделать если будеть возврат 0
    }

    @Override
    public List<City> getAllCity() {
        List<City> listCity = new LinkedList<>();
        connection = factory.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(queryGetAllCity);
            while(resultSet.next()){
                City city = new City();
                city.setIdCity(resultSet.getInt("id_city"));
                city.setNameCity(resultSet.getString("city_name"));
                city.setCountry(resultSet.getString("country"));
                listCity.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            factory.closeConnection();
        }
        return listCity;
    }
}
