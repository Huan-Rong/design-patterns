package site.bulibucai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 基于父类，实现静态代理设计模式
 */
@Service
public class ExtServiceProxy extends BaseService {

    private ExtService extService;

    @Autowired
    @Qualifier("extService")
    public void setExtService(ExtService extService) {
        this.extService = extService;
    }

    @Override
    public void baseServiceCheck() {
        log();
        extService.baseServiceCheck();
    }

    private void log() {
        System.out.println("log...");
    }
}
