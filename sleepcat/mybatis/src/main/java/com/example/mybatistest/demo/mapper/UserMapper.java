package com.example.mybatistest.demo.mapper;

import com.example.mybatistest.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User Sel(int id);
}