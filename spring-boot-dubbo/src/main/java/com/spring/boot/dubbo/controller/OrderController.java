package com.spring.boot.dubbo.controller;

import com.spring.boot.entity.User;
import com.spring.boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Autowired
    public OrderService orderService;

    @ResponseBody
    @RequestMapping("/getUser")
    public User getUser(){
        return orderService.getOrder();
    }


}
