package com.example.mybatistest.demo.controller;


import com.example.mybatistest.demo.entity.Challenge;
import com.example.mybatistest.demo.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatistest.demo.service.MiscFunction;

import java.util.List;

@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @GetMapping("/getChallengebyID")
    public Challenge getChallengeByID(@RequestParam("challengeID") String challengeID) {
        return challengeService.selectById(challengeID);
    }

    @PostMapping("/addChallenge")
    public String addChallenge(@RequestParam("title") String title,@RequestParam("describution") String describution,@RequestParam("flag") String flag,@RequestParam("challengeType")String challengeType){
        String cid=MiscFunction.getRandomString();
        if(challengeService.addChallenge(cid,title,describution,flag,challengeType)==1){
            return "{\"status\":\"1\",\"info\":\"题目添加成功\"}";
        }
        return "{\"status\":\"0\",\"info\":\"题目添加失败\"}";
    }
    @GetMapping("getAllChallenge")
    public List<Challenge> getAllChallenge() {
        List<Challenge> array=challengeService.getAllChallenge();
        System.out.println(array);
        return array;
    }
}
