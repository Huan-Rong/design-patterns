package site.bulibucai.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * 基于接口，来实现静态代理设计模式
 */
@Repository
//todo 解释实现接口 UserDao 的原因
public class UserDaoImplProxy implements UserDao {

    //todo 解释字段 userDaoImpl 的作用
    private UserDao userDaoImpl;

    @Autowired
    @Qualifier("userDaoImpl")
    public void setUserDaoImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public void addUser() {
        log();
        userDaoImpl.addUser();
    }

    @Override
    public void deleteUser() {
        log();
        userDaoImpl.deleteUser();
    }

    private void log() {
        System.out.println("log...");
    }
}
