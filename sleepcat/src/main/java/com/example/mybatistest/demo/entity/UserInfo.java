package com.example.mybatistest.demo.entity;

public class UserInfo {
    private String uid;
    private String country;
    private String school;

    public String getUid(){
        return uid;
    }
    public void setUid(String uid) {
        this.uid=uid;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country=country;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school=school;
    }
}
