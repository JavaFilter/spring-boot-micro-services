package com.spring.boot.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.spring.boot.entity.User;
import com.spring.boot.service.UserService;
import org.springframework.stereotype.Component;

@Service
@Component
public class UserServiceImpl implements UserService {

    public User getUser(){
        User user = new User("111","shenyu");
        return  user;
    }
}
