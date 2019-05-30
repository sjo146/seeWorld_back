package com.seeworld.hl.dao;

import com.seeworld.hl.domain.ImgMsg;
import com.seeworld.hl.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Mapper
public interface UserMapper {
    @Select("select * from User where u_username = #{username} and u_password=#{pwd}")
    User selectUserLogin(String username,String pwd);

    @Select("select * from User where u_username = #{username}")
    User selectUserByUsername(String username);

    @Select("select * from User where u_id = #{uid}")
    User selectUserByUId(int uid);

    @Insert("insert into User(u_username,u_password,u_personal) values (#{UUsername},#{UPwd},#{UPersonal})")
    @Options(useGeneratedKeys = true,keyProperty = "UId",keyColumn = "u_id")
    int insertUser(User user);

    @Update("update User set u_password=#{password} where u_id=#{uid}")
    int  updatePwd(String password,int uid);


}

