package com.spring.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.spring.cloud.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private EurekaClient  eurekaClient;

   /* @Autowired
    private DiscoveryClient discoveryClient;*/

    @GetMapping("/eureka-instance")
    public String serviceUrl(){
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("SPRING-BOOT-CLOUD-USER",false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/simple/{id}")
    public User getUser(@PathVariable String id){
        User user = new User(id,"shenyu");
        System.out.print("-------------------");
        return user;
    }
    @PostMapping("/getUser")
        public User getUser1(@RequestBody User user){
        return user;
    }

    /*@GetMapping("/eureka-instance")
    public String serviceUrl1(){
        ServiceInstance instance = this.discoveryClient.getLoca
        return instance.getHomePageUrl();
    }*/

}
