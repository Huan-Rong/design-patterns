package site.bulibucai.lazy;

import org.junit.Test;

public class SynchronizedBlockTickGeneratorTest {

    @Test
    public void getInstance() {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> System.out.println(SynchronizedBlockTickGenerator.getInstance())).start();
        }
    }
}