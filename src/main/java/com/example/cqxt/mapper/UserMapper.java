package com.example.cqxt.mapper;

import com.example.cqxt.beans.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsernamePassword(String username, String password);

    //List<User> selectUserByName(String name);
}