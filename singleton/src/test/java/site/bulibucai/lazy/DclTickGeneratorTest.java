package site.bulibucai.lazy;

import org.junit.Test;

public class DclTickGeneratorTest {

    @Test
    public void getInstance() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(DclTickGenerator.getInstance())).start();
        }
    }
}