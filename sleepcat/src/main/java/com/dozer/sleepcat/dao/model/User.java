package com.dozer.sleepcat.dao.model;

import lombok.Data;

@Data
public class User {
    private Integer uid;

    private String id;

    private String username;

    private String country;

    private String teamname;

    private Integer inteam;

    private Integer selfscore;
}
