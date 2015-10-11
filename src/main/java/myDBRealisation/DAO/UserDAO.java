package myDBRealisation.DAO;



import myDBRealisation.User;

import java.util.List;

/**
 * Created by ������� on 07.10.2015.
 *
 * ����� ������� ������ ����� ���������� � ��� ���� ������� ��� ���� ��������� ����������
 * ��� ��������� (� �������������� ���������) ���� ����������� ������� CRUD.
 */
public interface UserDAO {
    void addUser(User user);
    User getUserByName(String userName);
    boolean updateUserByID(User user);
    void removeUserByName(String userName);
    List<User> getAllUser();
}
