package com.example.mybatistest.demo.service;

import com.example.mybatistest.demo.entity.User;
import com.example.mybatistest.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User Sel(String id){
        return userMapper.Sel(id);
    }
    public User selectByUserNameAndPassword(String username,String password) {
        return userMapper.selectByUserNameAndPassword(username,password);
    }
    public int register(String uid,String userName,String passWord,String realName,String teamName,String teamId,Integer isAdmin){
        return userMapper.Register(uid,userName,passWord,realName,teamName,teamId,isAdmin);
    }
    public int joinTeam(String tid,String uid){
        return userMapper.joinTeam(tid,uid);
    }
}