package com.example.mybatistest.demo.service;

import com.example.mybatistest.demo.entity.Challenge;
import com.example.mybatistest.demo.mapper.ChallengeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChallengeService {
    @Autowired
    ChallengeMapper challengeMapper;
    public Challenge selectById(String cid){
        return challengeMapper.selectById(cid);
    }

    public Challenge selectByChallengeTitle(String title){
        return challengeMapper.selectByChallengeTitle(title);
    }

    public int addChallenge(String cid, String title, String describution, String flag, String challengeType){
        return challengeMapper.addChallenge(cid,title,describution,flag,challengeType);
    }
    public List<Challenge> getAllChallenge() {
        return challengeMapper.getAllChallenge();
    }
}
