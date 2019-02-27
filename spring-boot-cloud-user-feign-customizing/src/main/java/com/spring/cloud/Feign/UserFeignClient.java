package com.spring.cloud.Feign;

import com.spring.cloud.Entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "spring-boot-cloud-user",configuration = FeignConfiguration.class)
public interface UserFeignClient {

    //@RequestMapping(value = "/simple/{id}",method = RequestMethod.GET )
    @RequestLine("GET /simple/{id}")
    public User getUser(@Param("id") String id);

   /* @RequestMapping(value = "/getUser",method = RequestMethod.GET )
    public User getUser1(@RequestBody User user);
*/
}
