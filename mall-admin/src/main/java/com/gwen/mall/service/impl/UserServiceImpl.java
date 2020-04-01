package com.gwen.mall.service.impl;

import com.gwen.mall.dao.UserMapper;
import com.gwen.mall.dto.User;
import com.gwen.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：
 * Created By guowen
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;
    public User get(){
        return mapper.selectByPrimaryKey(1L);
    }
}
