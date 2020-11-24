package com.example.mybatistest.demo.entity;

public class Team {
    private String tid;
    private String teamName;
    private String uid;
    private Integer score;


    public String getTid() {
        return tid;
    }
    public void setTid(String tid) {
        this.tid=tid;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName){
        this.teamName=teamName;
    }
    public String getUid(){
        return uid;
    }
    public void setUid(String uid) {
        this.uid=uid;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score=score;
    }

    @Override
    public String toString() {
        return "{" +
                "\"tid\":\""+tid+"\"," +
                "\"teamName\":\""+teamName+"\"," +
                "\"uid\":\""+uid+"\"," +
                "\"score\":"+score+"" +
                "}";
    }
}
