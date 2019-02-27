package com.shenyu.springbootdemo.Dao;

import com.shenyu.springbootdemo.Entiry.Demo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DemoDao extends CrudRepository<Demo,Integer> {

    @Query("select demo from Demo demo")
    public List<Demo> getDemoById();

}
