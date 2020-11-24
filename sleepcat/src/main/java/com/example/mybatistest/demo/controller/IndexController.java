package com.example.mybatistest.demo.controller;

import com.example.mybatistest.demo.exception.message.ReturnMessage;
import com.example.mybatistest.demo.exception.message.ReturnMessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("index")
    public ReturnMessage index() {
        return ReturnMessageUtil.sucess();
    }
}