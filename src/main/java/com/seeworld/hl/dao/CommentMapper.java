package com.seeworld.hl.dao;

import com.seeworld.hl.domain.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Mapper
@Component
public interface CommentMapper {
    @Insert("Insert into Comment(imgid,uid,pinglun) values (#{Imgid},#{Uid},#{Pinglun}) ")
    @Options(useGeneratedKeys = true,keyProperty = "Cid",keyColumn = "cid")
    int insertComment(Comment comment);

    @Select("Select * from Comment where imgid=#{Imgid}")
    ArrayList<Comment> getImgAllComment(@Param("Imgid")int imgid);

    @Select("Select * from Comment where uid=#{uid}")
    ArrayList<Comment> getUserAllComment(@Param("uid")int uid);

    @Delete("delete from Comment where cid=#{cid}")
    int deleteSingleComment(@Param("cid") int cid);
}
