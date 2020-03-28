package com.gwen.mall.controller;

import com.gwen.mall.fegin.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：
 * Created with IntelliJ IDEA
 * Created By guowen
 * Date: 2020/3/28
 * Time: 20:47
 */
@RestController
@RequestMapping("/shop")
public class DemoController {
    @Autowired
    private DemoService service;
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        service.getUser(name);
        return "hello "+name+"，this is first messge";
    }
}
