package com.spring.boot.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.spring.boot.entity.User;
import com.spring.boot.service.OrderService;
import com.spring.boot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference
    public UserService userService;

    public User getOrder(){
        return userService.getUser();
    }

}
