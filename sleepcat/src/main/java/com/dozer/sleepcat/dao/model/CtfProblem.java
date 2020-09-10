package com.dozer.sleepcat.dao.model;


import lombok.Data;

import java.util.List;

@Data
public class CtfProblem {
    private Integer pid;

    private String problemname;

    private String problemcontribution;

    private Integer solvenum;

    private Integer score;

    private List<User> solveuser;
}
