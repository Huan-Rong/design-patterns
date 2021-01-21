package site.bulibucai.lazy;

import org.junit.Test;

public class SynchronizedTickGeneratorTest {

    @Test
    public void getInstance() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(SynchronizedTickGenerator.getInstance());
            }).start();
        }
    }
}