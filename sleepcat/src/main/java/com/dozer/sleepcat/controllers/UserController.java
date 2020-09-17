package com.dozer.sleepcat.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/User")
public class UserController {
    //@PostMapping("getUserInfo")
    @RequestMapping("getUserInfo")
    public String getUser()
    {
        return "UserTest";
    }
}
