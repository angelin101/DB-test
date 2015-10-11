package myDBRealisation.DAO;

import myDBRealisation.City;

import java.util.List;

/**
 * Created by Ангелин on 07.10.2015.
 */
public interface CityDAO {
    void addCity(City ciry);
    City getCityByName(String nameCity);
    boolean updateCityByID(City city);
    void removeCityByName(String nameCity);
    int getIDByCityName(String nameCity);
    List<City> getAllCity();
}
