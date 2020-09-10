package com.dozer.sleepcat.dao.dao;

import com.dozer.sleepcat.dao.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByUID(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByUID(Integer uid);

    User selectByUserName(String username);

    int updateByUID(User record);

    int updateByUserName(User record);

    List<User> findByStatusAndType(@Param("status") Integer status,@Param("type") Integer type);
}
