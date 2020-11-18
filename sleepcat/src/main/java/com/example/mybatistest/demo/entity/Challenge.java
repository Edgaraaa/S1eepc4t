package com.example.mybatistest.demo.entity;

import java.util.Date;

public class Challenge {
    private String cid;
    private String title;
    private String describution;
    private String flag;
    private String challengeType;

    public String getCid() {
        return cid;
    }
    public void setCid(String cid) {
        this.cid=cid;
    }
    public String getTitle(String title) {
        return title;
    }
    public void setTitle(String title) {
        this.title=title;
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag){
        this.flag=flag;
    }
    public String getDescribution() {
        return describution;
    }
    public void setDescribution(String describution) {
        this.describution=describution;
    }
    public String getChallengeType() {
        return challengeType;
    }
    public void setChallengeType(String challengeType) {
        this.challengeType=challengeType;
    }

}
