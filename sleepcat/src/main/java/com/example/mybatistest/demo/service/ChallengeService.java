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

    public Challenge selectByChallengeTitle(String titles){
        return challengeMapper.selectByChallengeTitle(titles);
    }

    public int addChallenge(String cid, String titles, String describution, String flag, String challengeType,String mode,Integer score){
        return challengeMapper.addChallenge(cid,titles,describution,flag,challengeType,mode,score);
    }
    public List<Challenge> getAllChallenge() {
        return challengeMapper.getAllChallenge();
    }
    public Challenge selectByFlag(String flag,String cid) {
        return challengeMapper.selectByFlag(flag,cid);
    }
    public int updateByID(String cid,String titles,String describution,String flag,String challengeType,String mode,Integer score,Integer deal){ return challengeMapper.updateByID(cid,titles,describution,flag,challengeType,mode,score,deal);}
}
