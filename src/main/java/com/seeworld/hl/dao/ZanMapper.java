package com.seeworld.hl.dao;

import com.seeworld.hl.domain.Zan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Mapper
@Component
public interface ZanMapper {
    @Insert("Insert into Zan(imgid,iszan,uid) values (#{Imgid},#{Iszan},#{Uid}) ")
    int insertOriginalZan(Zan zan);

    @Select("select * from Zan where imgid=#{imgid} and uid=#{uid}")
    Zan findZanmsg(@Param("imgid") int id,@Param("uid")int uid);

    @Update("update Zan set iszan=#{Iszan} where imgid=#{Imgid} and uid=#{Uid} ")
    int  updateZanState(Zan zan);

    @Select("select * from Zan where uid=#{uid}")
    ArrayList<Zan> getAllZan( @Param("uid") int uid);
}
