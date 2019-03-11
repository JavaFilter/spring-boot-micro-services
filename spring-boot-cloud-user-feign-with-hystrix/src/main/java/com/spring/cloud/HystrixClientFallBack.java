package com.spring.cloud;

import com.spring.cloud.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallBack implements UserFeignClient {

    @Override
    public User getUser(String id){
        User user = new User();
        user.setId("111");
        user.setName("shenyufeign");
        return  user;
    }

}
