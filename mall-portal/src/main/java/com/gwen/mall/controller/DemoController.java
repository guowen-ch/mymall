package com.gwen.mall.controller;

import com.gwen.mall.fegin.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：
 * Created By guowen
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
