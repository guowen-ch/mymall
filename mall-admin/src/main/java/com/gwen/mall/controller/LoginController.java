package com.gwen.mall.controller;

import com.gwen.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description：
 * Created with IntelliJ IDEA
 * Created By guowen
 * Date: 2020/3/28
 * Time: 17:21
 */
@RestController
@RequestMapping("/sys/user")
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/get")
    public void get(@RequestParam String id){
        System.out.println(id);
        userService.get();
    }
}
