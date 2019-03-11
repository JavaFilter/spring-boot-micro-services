package com.spring.cloud;


import com.spring.cloud.Entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient> {

    private final Logger logger = LoggerFactory.getLogger(HystrixClientFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        logger.error("fallback ! :"+cause.getMessage());
        return (UserFeignClientWithFactory) id -> {
            User user = new User();
            user.setId("2222");
            user.setName("shenyuFeignFactory");
            return user;
        };
    }

}
