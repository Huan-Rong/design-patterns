package site.bulibucai.hungry;

import org.junit.Assert;
import org.junit.Test;

public class NumberGeneratorTest {

    @Test
    public void getInstance() {
        NumberGenerator instance = NumberGenerator.getInstance();
        NumberGenerator instance1 = NumberGenerator.getInstance();
        Assert.assertEquals(instance, instance1);
    }

}