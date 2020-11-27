package com.example.mybatistest.demo.service;

import com.example.mybatistest.demo.entity.UserInfo;
import com.example.mybatistest.demo.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo getUserInfo(String uid){
        return userInfoMapper.getUserInfo(uid);
    }
}
