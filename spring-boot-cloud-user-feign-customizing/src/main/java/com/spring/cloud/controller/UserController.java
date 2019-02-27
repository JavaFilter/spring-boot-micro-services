package com.spring.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.spring.cloud.Entity.User;
import com.spring.cloud.Feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private EurekaClient  eurekaClient;

   /* @Autowired
    private DiscoveryClient discoveryClient;*/

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/eureka-instance")
    public String serviceUrl(){
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("SPRING-BOOT-CLOUD-USER",false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/simple/{id}")
    public User getUserById(@PathVariable String id){
        return this.userFeignClient.getUser(id);
    }

    /*@GetMapping("/getUser")
    public User getUserById1(User user){
        return this.userFeignClient.getUser1(user);
    }*/
    /*@GetMapping("/eureka-instance")
    public String serviceUrl1(){
        ServiceInstance instance = this.discoveryClient.getLoca
        return instance.getHomePageUrl();
    }*/

}
