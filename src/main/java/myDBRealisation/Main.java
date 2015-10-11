package myDBRealisation;

import myDBRealisation.DAO.CityDAO;
import myDBRealisation.DAO.MyDAO.MyDAOFactory;
import myDBRealisation.DAO.UserDAO;

/**
 * Created by Ангелин on 03.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        CityDAO cityDAO = MyDAOFactory.getCityDAO();
        UserDAO userDAO = MyDAOFactory.getUserDAO();


    }
}
