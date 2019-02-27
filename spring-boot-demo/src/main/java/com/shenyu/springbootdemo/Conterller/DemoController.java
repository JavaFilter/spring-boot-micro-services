package com.shenyu.springbootdemo.Conterller;

import com.shenyu.springbootdemo.Entiry.Demo;
import com.shenyu.springbootdemo.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


@RequestMapping("/demo")
@RestController
public class DemoController {


    @Resource
    public DemoService demoService;

    @RequestMapping(value = "/login")
    public void Demo(){
        Demo  demo = new Demo();
        demo.setId(2);
        demo.setName("沈羽");
        demoService.saveDemo(demo);
    }

    @RequestMapping(value = "/list")
    public List<Demo> getDemoList(){
        List<Demo> demo = demoService.findDemoById();
        //modelAndView.setViewName("list");
        //modelAndView.addObject("demo",((List) demo).get(0));
        return demo;
    }

}
