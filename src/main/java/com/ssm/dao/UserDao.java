package com.ssm.dao;

import com.ssm.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("select * from user where username=#{username}")
    User selectUserByUsername(@Param("username") String username);
}
