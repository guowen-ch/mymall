package com.gwen.mall.service.impl;

import com.gwen.mall.dao.UserMapper;
import com.gwen.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：
 * Created with IntelliJ IDEA
 * Created By guowen
 * Date: 2020/3/28
 * Time: 18:11
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;
    public void get(){
        System.out.println(mapper.selectByPrimaryKey("1"));
    }
}
