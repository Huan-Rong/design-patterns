package site.bulibucai;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AppTest {
    @Test
    public void jdkProxyTest() {
        HelloInterface helloInterface = (HelloInterface) Proxy.newProxyInstance(AppTest.class.getClassLoader(),
                new Class[]{HelloInterface.class}, new InvocationHandler() {
                    //todo 解释形参 Method method 的作用
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("hello")) {
                            System.out.println("hello " + args[0]);
                        } else if (method.getName().equals("morning")) {
                            System.out.println("morning " + args[0]);
                        }
                        return null;
                    }
                });
        helloInterface.hello("ian");
        helloInterface.morning("lna");
    }
}
