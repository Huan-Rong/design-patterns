package site.bulibucai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import site.bulibucai.config.AppConfig;
import site.bulibucai.service.BaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class BaseOnSuperClassTest {

    @Autowired
    @Qualifier("extService")
    private BaseService extService;

    @Autowired
    @Qualifier("extServiceProxy")
    private BaseService extServiceProxy;

    @Test
    public void nonProxyTest() {
        extService.baseServiceCheck();
    }

    @Test
    public void proxyTest() {
        extServiceProxy.baseServiceCheck();
    }
}
