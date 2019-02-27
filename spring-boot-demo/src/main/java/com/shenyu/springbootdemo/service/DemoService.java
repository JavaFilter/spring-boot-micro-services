package com.shenyu.springbootdemo.service;

import com.shenyu.springbootdemo.Dao.DemoDao;
import com.shenyu.springbootdemo.Entiry.Demo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class DemoService {

    @Resource
    private DemoDao demoDao;

    @Transactional
    public void saveDemo(Demo demo){
        demoDao.save(demo);
    }


    @Transactional
    @Cacheable(value = "findDemoById")
    public List<Demo> findDemoById(){
        System.out.println("进去redis缓存--------------");
        return demoDao.getDemoById();
    }

}
