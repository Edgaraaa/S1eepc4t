package com.example.mybatistest.demo.mapper;


import com.example.mybatistest.demo.entity.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMapper {
    Team selectTeamByID(String tid);
    List<Team> getRank();
    Integer updateScore(String tid,Integer score);
}
