package com.seeworld.hl.dao;

import com.seeworld.hl.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Select("select * from User where u_username = #{username} and u_password=#{pwd}")
    User selectUserLogin(String username,String pwd);

    @Select("select * from User where u_username = #{username}")
    User selectUserByUsername(String username);

    @Insert("insert into User(u_username,u_password) values (#{UUsername},#{UPwd})")
    @Options(useGeneratedKeys = true,keyProperty = "UId",keyColumn = "u_id")
    int insertUser(User user);
}

