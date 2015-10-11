package myDBRealisation.DAO.MyDAO;

import myDBRealisation.DAO.UserDAO;
import myDBRealisation.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ангелин on 09.10.2015.
 */
public class MyUserDAOTest {

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setId(69);
        user.setName("Andrey");
        user.setAge(27);
        user.setCity("Gorlovka");
        UserDAO userDAO = MyDAOFactory.getUserDAO();
        userDAO.addUser(user);
    }

    @Test
    public void testGetUserByName() throws Exception {
        User user = new User();
        user.setId(56);
        user.setName("Ivan");
        user.setAge(35);
        user.setCity("Kyiv");
        User userRes = null;
        UserDAO userDAO = MyDAOFactory.getUserDAO();
        userRes = userDAO.getUserByName("Ivan");
        System.out.println(userRes);
        assertEquals(user, userRes);
    }

    @Test
    public void testUpdateUserByID() throws Exception {
        User user = new User();
        user.setId(27);
        user.setName("Lena");
        user.setAge(27);
        user.setCity("Moscow");
        UserDAO userDAO = MyDAOFactory.getUserDAO();
        assertTrue(userDAO.updateUserByID(user));
    }

    @Test
    public void testRemoveUserByName() throws Exception {
        UserDAO userDAO = MyDAOFactory.getUserDAO();
        userDAO.removeUserByName("Tzar");
    }

    @Test
    public void testGetAllUser() throws Exception {
        UserDAO userDAO = MyDAOFactory.getUserDAO();
        List<User> userList = userDAO.getAllUser();
        System.out.println(userList.size());
        for (User u : userList){
            System.out.println(u);
            System.out.println("---------------------");
        }
    }
}