package site.bulibucai;

import org.junit.Test;

public class AppTest {
    @Test
    public void createImplementTest() throws Exception {
        NonImplementInterface impl = ImplementFactory.createImplement();
        impl.hello("ian");
    }

    @Test
    public void createImplement2Test() throws Exception {
        NonImplementInterface impl = ImplementFactory.createImplement2(NonImplementInterface.class,
                "{System.out.println(\"hello:\" + $1 + \", morning!\");}");
        impl.hello("ian");
    }

    @Test
    public void createImplement3Test() throws Exception {
        ImplementFactory.createImplement3(NonImplementInterface.class, new InvocationHandler() {
            @Override
            public Object invoke(String methodName, Object[] args) {
                if (methodName.equals("hello")) {
                    System.out.println("hello:" + args[0]);
                }
                return null;
            }
        }).hello("ian");
    }

    @Test
    public void createImplement3Test2() throws Exception {
        ImplementFactory.createImplement3(OtherNonImplementInterface.class, new InvocationHandler() {
            @Override
            public Object invoke(String methodName, Object[] args) {
                if (methodName.equals("morning")) {
                    System.out.println("morning, " + args[0] + " and " + args[1]);
                }
                return null;
            }
        }).morning("ian", "lna");
    }
}
