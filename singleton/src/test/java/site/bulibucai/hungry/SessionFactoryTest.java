package site.bulibucai.hungry;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SessionFactoryTest {

    @Test
    public void getInstance() {
        SessionFactory instance = SessionFactory.getInstance();
        SessionFactory instance1 = SessionFactory.getInstance();
        Assert.assertEquals(instance, instance1);
    }
}