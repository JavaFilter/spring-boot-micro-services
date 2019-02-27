package com.shenyu.springbootdemo.Conterller;

import com.shenyu.springbootdemo.Entiry.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/login")
    public String Hello(){
        return "hello world!-2019-----";
    }

    @RequestMapping(value = "/login1")
    public String Hello1(){
        return "hello world!11122221";
    }

    /**
     * Spring boot 默认使用的json解析框架是jackson
     * @return
     */
    @RequestMapping(value = "/getJson")
    public Demo getJson(){
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("沈羽");
        return demo;
    }

}
