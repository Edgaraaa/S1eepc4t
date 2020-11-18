package com.example.mybatistest.demo.mapper;

import com.example.mybatistest.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User Sel(String id);
    User selectByUserNameAndPassword(String username,String password);
    int Register(String uid,String userName,String passWord,String realName,String teamName,String teamId,Integer isAdmin);
}