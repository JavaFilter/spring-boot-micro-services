package com.spring.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.spring.cloud.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class UserController {

    @Autowired
    private EurekaClient  eurekaClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //@Autowired
    //private RestTemplate restTemplate;

   /* @Autowired
    private DiscoveryClient discoveryClient;*/

    @GetMapping("/eureka-instance")
    public String serviceUrl(){
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("SPRING-BOOT-CLOUD-USER",false);
        return instance.getHomePageUrl();
    }

    /*@GetMapping("/eureka-instance")
    public String serviceUrl1(){
        ServiceInstance instance = this.discoveryClient.getLoca
        return instance.getHomePageUrl();
    }*/

   /* @GetMapping("/user/{id}")
    public User findById(@PathVariable String id){
        //return this.restTemplate.getForObject("http://172.16.88.128/shortmessageservice.asmx/Send?sysName=DFCFMonitor&phoneNumbers=123123123123&content=2131&priority=1", User.class);
        return  this.restTemplate.getForObject("http://spring-boot-cloud-user/simple/"+id,User.class);  //("http://spring-boot-cloud-user/simple/","User.class");
    }*/

    @GetMapping("/ribbon/get1")
    public String eureka() {
        ServiceInstance instance = loadBalancerClient.choose("spring-boot-cloud-user");
        System.out.println("host:" + instance.getHost() + ",port:" + instance.getPort() + ",serviceId=" + instance.getServiceId() + ",uri=" + instance.getUri());
        return "/ribbon/get1's demo, please to see console output";
    }
}
