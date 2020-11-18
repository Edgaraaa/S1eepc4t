package com.example.mybatistest.demo.entity;

public class User {
    private String uid;
    private String userName;
    private String passWord;
    private String realName;
    private String teamName;
    private String teamId;
    private Integer isAdmin;

    public String getUid() {
        return uid;
    }

    public void setUid(String id) {
        this.uid = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setTeamName(String teamName) {
        this.teamName=teamName;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamId(String teamId) {
        this.teamId=teamId;
    }
    public String getTeamId() {
        return teamId;
    }
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin=isAdmin;
    }
    public Integer getIsAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
