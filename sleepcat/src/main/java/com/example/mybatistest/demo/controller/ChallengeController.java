package com.example.mybatistest.demo.controller;


import com.example.mybatistest.demo.entity.Challenge;
import com.example.mybatistest.demo.service.ChallengeService;
import com.example.mybatistest.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatistest.demo.service.MiscFunction;

import java.util.List;

@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private TeamService teamService;
    @GetMapping("/getChallengebyID")
    public String getChallengeByID(@RequestParam("challengeID") String challengeID) {
        Challenge challenge=challengeService.selectById(challengeID);
        if(challenge==null) {
            return "wrong";
        }
        String info=challenge.toString();
        return info;
    }

    @PostMapping("/addChallenge")
    public String addChallenge(@RequestParam("title") String title,@RequestParam("describution") String describution,@RequestParam("flag") String flag,
                               @RequestParam("challengeType")String challengeType,@RequestParam("mode") String mode,@RequestParam("score")Integer score){
        String cid=MiscFunction.getRandomString();
        if(challengeService.addChallenge(cid,title,describution,flag,challengeType,mode,score)==1){
            return "{\"status\":\"1\",\"info\":\"题目添加成功\"}";
        }
        return "{\"status\":\"0\",\"info\":\"题目添加失败\"}";
    }
    @GetMapping("/getAllChallenge")
    public String getAllChallenge() {
        List<Challenge> array=challengeService.getAllChallenge();
        String ret="[";
        for (int i=0;i<array.size();i++) {
            Challenge challenge=array.get(i);
            ret+=challenge.toString();
            if(i!=array.size()-1) {
                ret+=",";
            }
        }
        ret+="]";
        return ret;
    }

    @PostMapping("/submitFlag")
    public String submitFlag(@RequestParam("flag") String flag,@RequestParam("cid") String cid,@RequestParam("tid") String tid) {
        Challenge challenge = challengeService.selectByFlag(flag,cid);
        if(challenge!=null) {
            Integer score = challenge.getScore();
            Integer a=teamService.updateScore(tid,score);
            return "回答正确";
        }else {
            return "回答错误";
        }
    }
}
