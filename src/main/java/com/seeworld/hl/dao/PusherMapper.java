package com.seeworld.hl.dao;

import com.seeworld.hl.domain.ImgMsg;
import com.seeworld.hl.domain.Pusher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PusherMapper {
    @Insert("insert into Pusher(p_username,p_name,p_pwd,p_desc,p_phone) values (#{PUsername},#{PName},#{PPwd},#{Pdesc},#{PPhone})")
    @Options(useGeneratedKeys = true,keyProperty = "PId",keyColumn = "p_id")
    int addPusher(Pusher p);
}
