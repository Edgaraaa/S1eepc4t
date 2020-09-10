package com.dozer.sleepcat.dao.dao;


import org.springframework.stereotype.Repository;

@Repository
public interface CtfProblemMapper {
   int selectByPID(Integer pid);

}
