package com.example.mybatistest.demo.mapper;

import com.example.mybatistest.demo.entity.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {
    UserInfo getUserInfo(String uid);

}
