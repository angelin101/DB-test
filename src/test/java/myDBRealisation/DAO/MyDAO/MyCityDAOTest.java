package myDBRealisation.DAO.MyDAO;

import myDBRealisation.City;
import myDBRealisation.DAO.CityDAO;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by Ангелин on 07.10.2015.
 */
public class MyCityDAOTest {

    @org.junit.Test
    public void testGetCityByName() throws Exception {
        CityDAO cityDAO = MyDAOFactory.getCityDAO();
        City city;
        City city2 = new City();
        city2.setIdCity(9);
        city2.setNameCity("Gorlovka");
        city2.setCountry("Ukraine");
        city = cityDAO.getCityByName("Gorlovka");
        assertEquals(city2, city);
    /*    System.out.println(city);
        System.out.println("********");
        System.out.println(city2);
    */}

    @org.junit.Test
    public void testUpdateCity() throws Exception {
        City city = new City();
        city.setIdCity(24);
        city.setCountry("Australia");
        city.setNameCity("Sydney");
        CityDAO cityDAO = MyDAOFactory.getCityDAO();
        assertTrue(cityDAO.updateCityByID(city));
    }

    @org.junit.Test
    public void testRemoveCityByName() throws Exception {
        CityDAO cityDAO = MyDAOFactory.getCityDAO();
        cityDAO.removeCityByName("Sydney");
    }

    @org.junit.Test
    public void testAddCity() throws Exception {
        City city = new City();
        city.setIdCity(5);
        city.setNameCity("Sydney");
        city.setCountry("Australia");
        CityDAO cityDAO = MyDAOFactory.getCityDAO();
        cityDAO.addCity(city);
    }

    @org.junit.Test
    public void testGetIDByCityName() throws Exception{
        String name = "Berlin";
        assertEquals(15, MyDAOFactory.getCityDAO().getIDByCityName(name));
    }

    @org.junit.Test
    public void testGetAllCity() throws Exception {
        List<City> list = new LinkedList<>();
        City gorlovka = new City("Gorlovka", "Ukraine");
        City kyiv = new City("Kyiv", "Ukraine");
        City kharkiv = new City("Kharkiv", "Ukraine");
        City moscow = new City("Moscow", "Russia");
        City london = new City("London", "England");
        City berlin = new City("Berlin", "Germany");
        City rom = new City("Rom", "Italy");
        list.add(gorlovka);
        list.add(kyiv);
        list.add(kharkiv);
        list.add(moscow);
        list.add(london);
        list.add(berlin);
        list.add(rom);
        List<City> newCity;
        CityDAO cityDAO = MyDAOFactory.getCityDAO();
        newCity = cityDAO.getAllCity();
        for (City city : newCity){
            System.out.println(city);
            System.out.println("----------------------------");
        }
    }
}