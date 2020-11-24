package com.example.mybatistest.demo.controller;

import com.example.mybatistest.demo.entity.Team;
import com.example.mybatistest.demo.entity.User;
import com.example.mybatistest.demo.service.TeamService;
import com.example.mybatistest.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private UserService userService;
    @PostMapping("/getTeamInfoByID")
    public String getTeamByID(@RequestParam("id") String tid) {
        Team team=teamService.selectTeamByID(tid);
        if(team==null) {
            return "wrong";
        }
        String info=team.toString();
        System.out.println(info);
        return info;
    }

    @PostMapping("/addScoreTest")
    public Integer addScore(@RequestParam("tid") String tid,@RequestParam("score") Integer score){
        Integer a = teamService.updateScore(tid,score);
        System.out.println(a);
        return 1;
    }
    @PostMapping("/joinTeam")
    public String joinTeam(@RequestParam("tid") String tid,@RequestParam("uid") String uid) {
        Team s=teamService.selectTeamByID(tid);
        if(s==null) {
            return "团队不存在";
        }
        int a = userService.joinTeam(tid,uid);
        if(a==1) {
            return "加入战队成功";
        }else {
            return "加入战队失败";
        }
    }
}
