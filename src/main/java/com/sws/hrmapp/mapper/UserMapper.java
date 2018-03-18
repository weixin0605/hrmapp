package com.sws.hrmapp.mapper;

import com.sws.hrmapp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByLOginnameAndPassword(@Param("loginname")String loginname, @Param("password") String password);

    List<User> selectAllUsers();
}