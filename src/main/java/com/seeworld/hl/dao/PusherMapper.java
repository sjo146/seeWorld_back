package com.seeworld.hl.dao;

import com.seeworld.hl.domain.ImgMsg;
import com.seeworld.hl.domain.Pusher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PusherMapper {
    @Insert("insert into Pusher(p_username,p_name,p_pwd,p_desc,p_phone) values (#{PUsername},#{PName},#{PPwd},#{PDesc},#{PPhone})")
    @Options(useGeneratedKeys = true,keyProperty = "PId",keyColumn = "p_id")
    int insertPusher(Pusher p);

    @Select("select * from Pusher where p_username = #{username} and p_pwd = #{password}")
    Pusher queryPusherLogin(@Param("username") String username, @Param("password") String password);

    @Select("select * from Pusher where p_id = #{pid}")
    Pusher selectByPId(int pid);

    @Update("update Pusher set p_username=#{PUsername},p_name=#{PName},p_desc=#{PDesc},p_phone=#{PPhone} where p_id=#{PId}")
    int updatePusher(Pusher p);

    @Select("select　* from Pusher where username=#{username} ")
    Pusher queryByUsername(String username);

}
