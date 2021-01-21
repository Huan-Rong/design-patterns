package site.bulibucai.inner;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class StaticInnerTickGeneratorTest {

    @Test
    public void getInstance() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(StaticInnerTickGenerator.getInstance())).start();
        }
    }

    @Test
    public void getInstance2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //正常方式获取实例
        StaticInnerTickGenerator instance = StaticInnerTickGenerator.getInstance();
        //反射方式获取实例
        Constructor<StaticInnerTickGenerator> declaredConstructor =
                StaticInnerTickGenerator.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        StaticInnerTickGenerator instance1 = declaredConstructor.newInstance(null);
        declaredConstructor.setAccessible(false);
        //反射带来的颠覆
        Assert.assertNotEquals(instance, instance1);
    }
}