package com.hwj.dao;

import com.hwj.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserDao {
    User selectByUsername(@Param("username") String username);
}
