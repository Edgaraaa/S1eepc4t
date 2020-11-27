package com.example.mybatistest.demo.controller;

import com.example.mybatistest.demo.entity.Challenge;
import com.example.mybatistest.demo.entity.Team;
import com.example.mybatistest.demo.entity.User;
import com.example.mybatistest.demo.service.TeamService;
import com.example.mybatistest.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rank")
public class RankController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private UserService userService;
    @GetMapping("getRank")
    public String getRank() {
        List<Team> array=teamService.getRank();
        String ret="[";
        for (int i=0;i<array.size();i++) {
            Team team=array.get(i);
            ret+=team.toString();
            if(i!=array.size()-1) {
                ret+=",";
            }
        }
        ret+="]";
        return ret;
    }

    @PostMapping("/getTeamRank")
    public Integer getTeamRank(@RequestParam("uid")String uid) {
        User user=userService.Sel(uid);
        String teamid=user.getTeamId();
        System.out.println("teamid"+teamid);
        List<Team> array=teamService.getRank();
        Integer index=0;
        for (int i=0;i<array.size();i++) {
            Team team=array.get(i);
            System.out.println(team.getTid());
            if(teamid.equals(team.getTid())){
                index=i;
                System.out.println(index+"111111111111");
            }
        }
        if(index+1==0) {
            return -1;
        }else{
            return index+1;
        }
    }
}
