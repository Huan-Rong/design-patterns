package site.bulibucai.lazy;

import org.junit.Test;

import static org.junit.Assert.*;

public class TickGeneratorTest {

    @Test
    public void getInstance() {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(TickGenerator.getInstance());
            }).start();
        }
    }
}