package com.example.mybatistest.demo.controller;

import com.example.mybatistest.demo.entity.User;
import com.example.mybatistest.demo.service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatistest.demo.service.MiscFunction;
@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public User GetUser(@PathVariable String id){
        return userService.Sel(id);
    }

    @PostMapping("/getUser")
    public User getUserByLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
        User user= userService.selectByUserNameAndPassword(username,password);
        if (user==null) {
            User user1=new User();
            user1.setUserName("None");
            return user1;
        }else {
            return user;
        }
    }
    @RequestMapping("/register")
    public String register(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("cpassword") String cpassword,@RequestParam("email") String email) {
        String uid=MiscFunction.getRandomString();
        System.out.println(password);
        System.out.println(cpassword);
        if(!password.equals(cpassword)) {
            return "两次密码不统一";
        }
        String teamName="undefinded";
        String teamId="undefinded";
        Integer isAdmin=0;

        userService.register(uid,username,password,email,teamName,teamId,isAdmin);
        return "注册成功";
    }
}