package com.example.mybatistest.demo.service;


import com.example.mybatistest.demo.entity.Team;
import com.example.mybatistest.demo.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamMapper teamMapper;
    public Team selectTeamByID(String tid) {
        return teamMapper.selectTeamByID(tid);
    }
    public List<Team> getRank() {
        return teamMapper.getRank();
    }
    public Integer updateScore(String tid,Integer score){
        Integer oldscore=teamMapper.selectTeamByID(tid).getScore();
        return teamMapper.updateScore(tid,oldscore+score);
    }
}
