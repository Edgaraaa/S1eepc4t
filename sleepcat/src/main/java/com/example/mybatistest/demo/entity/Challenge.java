package com.example.mybatistest.demo.entity;

import java.util.Date;

public class Challenge {
    private String cid;
    private String titles;
    private String describution;
    private String flag;
    private String challengeType;
    private String mode;
    private Integer score;
    private Integer deal;

    public String getCid() {
        return cid;
    }
    public void setCid(String cid) {
        this.cid=cid;
    }
    public String getTitle(String titles) {
        return titles;
    }
    public void setTitle(String titles) {
        this.titles=titles;
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
    public String getMode() {
        return mode;
    }
    public void  setMode(String mode) {
        this.mode=mode;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score=score;
    }
    public Integer getDeal() {
        return deal;
    }
    public void setDeal(Integer deal){
        this.deal=deal;
    }
    @Override
    public String toString() {
        return "{\"cid\":\""+cid+"\",\"titles\":\""+titles+"\"," +
                "\"describution\":\""+describution+"\",\"flag\":\""+flag+"\"," +
                "\"challengeType\":\""+challengeType+"\"," +
                "\"mode\":\""+mode+"\",\"score\":"+score+",\"deal\":"+deal+"}";
    }
 }
