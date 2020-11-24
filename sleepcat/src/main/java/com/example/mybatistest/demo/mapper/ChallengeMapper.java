package com.example.mybatistest.demo.mapper;

import com.example.mybatistest.demo.entity.Challenge;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface ChallengeMapper {
    Challenge selectById(String cid);
    Challenge selectByChallengeTitle(String title);
    int addChallenge(String cid, String titles, String describution,
                     String flag, String challengeType,String mode,Integer score);
    List<Challenge> getAllChallenge();
    Challenge selectByFlag(String flag,String cid);

}
