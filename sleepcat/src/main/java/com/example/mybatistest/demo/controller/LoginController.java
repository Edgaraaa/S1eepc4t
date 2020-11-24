package com.example.mybatistest.demo.controller;

import com.example.mybatistest.demo.entity.RedisUtil;
import com.example.mybatistest.demo.exception.message.CodeEnum;
import com.example.mybatistest.demo.exception.message.ReturnMessage;
import com.example.mybatistest.demo.exception.message.ReturnMessageUtil;
import com.example.mybatistest.demo.service.JWTService;
import com.example.mybatistest.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class LoginController {
    Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;
    private Integer time=3000;
    @RequestMapping("/login")
    public ReturnMessage<Object> login(String loginName, String password, HttpServletRequest request) {
        if(userService.selectByUserNameAndPassword(loginName,password)==null) {
            return ReturnMessageUtil.error(CodeEnum.LOGINNAMEANDPWDERROR);
        }

        Map<String,String> userInfo = createUserInfoMap(loginName,password);
        String token = jwtService.createToken(userInfo, 1);

        ServletContext context = request.getServletContext();
        context.setAttribute(token, token);
        log.info("token:"+token);
        redisUtil.set(token,loginName,time);
        return ReturnMessageUtil.sucess(token);
    }

    @GetMapping("/logout")
    public ReturnMessage<?> logout(String token,String issuer,HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        context.removeAttribute(token);
        redisUtil.del(token);
        return ReturnMessageUtil.sucess();
    }


    private Map<String,String> createUserInfoMap(String loginName, String password) {
        Map<String,String> userInfo = new HashMap<String,String>();
        userInfo.put("loginName", loginName);
        userInfo.put("password", password);
        return userInfo;
    }



}