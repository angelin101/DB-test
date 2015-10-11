package myDBRealisation.DAO;



import myDBRealisation.User;

import java.util.List;

/**
 * Created by Ангелин on 07.10.2015.
 *
 * Можно сделать методы более абстрактно и над ними сделать еще один интерфейс обобщающий
 * эти интерфесы (с использыванием Генериков) типа стандартных методов CRUD.
 */
public interface UserDAO {
    void addUser(User user);
    User getUserByName(String userName);
    boolean updateUserByID(User user);
    void removeUserByName(String userName);
    List<User> getAllUser();
}
