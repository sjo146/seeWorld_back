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

    @Select("select count(*) from Pusher where p_username = #{username} and p_pwd = #{password}")
    int queryPusherLogin(@Param("username") String username, @Param("password") String password);

}
