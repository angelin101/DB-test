package myDBRealisation.DAO;

import java.sql.Connection;

/**
 * Created by ������� on 07.10.2015.
 */
public interface DAOFactory {
    Connection getConnection();
    void closeConnection();
}
