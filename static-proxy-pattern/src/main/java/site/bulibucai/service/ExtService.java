package site.bulibucai.service;

import org.springframework.stereotype.Service;

@Service
public class ExtService extends BaseService {

    @Override
    public void baseServiceCheck() {
        System.out.println("base service check in ExtService");
    }
}
