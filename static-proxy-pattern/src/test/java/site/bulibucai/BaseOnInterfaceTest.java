package site.bulibucai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import site.bulibucai.config.AppConfig;
import site.bulibucai.dao.UserDao;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class BaseOnInterfaceTest {

    @Autowired
    //todo 解释 @Qualifier 注解的作用
    @Qualifier("userDaoImpl")
    //todo 解释为什么将 userDaoImpl 字段声明为 UserDao 类型
    private UserDao userDaoImpl;

    @Autowired
    @Qualifier("userDaoImplProxy")
    //todo 解释为什么将 userDaoImplProxy 字段声明为 UserDao 类型
    private UserDao userDaoImplProxy;

    @Test
    public void nonProxyTest() {
        userDaoImpl.addUser();
        userDaoImpl.deleteUser();
    }

    @Test
    public void proxyTest() {
        userDaoImplProxy.addUser();
        userDaoImplProxy.deleteUser();
    }
}
