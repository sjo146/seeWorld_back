package com.seeworld.hl.dao;

import com.seeworld.hl.domain.Zan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ZanMapper {
    @Insert("Insert into Zan(imgid,iszan) values (#{Imgid},#{Iszan}) ")
    int insertOriginalZan(Zan zan);

    @Select("select * from Zan where imgid=#{imgid}")
    Zan findZanmsg(@Param("imgid") int id);

    @Update("update Zan set iszan=#{Iszan} where imgid=#{Imgid} ")
    int  updateZanState(Zan zan);
}
