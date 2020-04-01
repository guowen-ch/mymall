package com.gwen.mall.controller;

import com.gwen.mall.dto.User;
import com.gwen.mall.service.UserService;
import com.gwen.mall.utils.MD5Utils;
import com.gwen.mall.utils.ResultInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description：
 * Created By guowen
 */
@RestController
@RequestMapping("/sys/user")
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/get")
    public User get(@RequestParam String id){
        System.out.println(id);
        return userService.get();
    }
    @GetMapping("/login")
    @ApiOperation(value = "登录接口", notes = "登录接口")
    ResultInfo Login(String username, String password) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return ResultInfo.success(token);
    }
}
