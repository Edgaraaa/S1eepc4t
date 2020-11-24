package com.example.mybatistest.demo.controller;

import com.example.mybatistest.demo.entity.Challenge;
import com.example.mybatistest.demo.entity.Team;
import com.example.mybatistest.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rank")
public class RankController {
    @Autowired
    private TeamService teamService;

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
}
