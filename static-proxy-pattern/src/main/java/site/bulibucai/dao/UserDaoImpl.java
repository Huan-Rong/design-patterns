package site.bulibucai.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("add...");
    }

    @Override
    public void deleteUser() {
        System.out.println("delete...");
    }
}
