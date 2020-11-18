package com.example.mybatistest.demo.service;

public class MiscFunction {
    public static char byteAsciiToChar(int ascii){
        char ch = (char)ascii;
        return ch;
    }
    public static String getRandomString() {
        int max=57;
        int min=48;
        String str="";
        for(int i=0;i<6;i++) str+= byteAsciiToChar((int)(Math.random()*(max-min)+min));
        return str;
    }
}
