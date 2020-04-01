package com.gwen.mall.dao;

import com.gwen.mall.dto.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Long menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<String> listUserPerms(Long id);
}