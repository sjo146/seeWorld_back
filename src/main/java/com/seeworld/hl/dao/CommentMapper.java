package com.seeworld.hl.dao;

import com.seeworld.hl.domain.Comment;
import com.seeworld.hl.domain.Comment_name;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Mapper
@Component
public interface CommentMapper {
    @Insert("Insert into Comment(imgid,uid,pinglun) values (#{Imgid},#{Uid},#{Pinglun}) ")
    @Options(useGeneratedKeys = true,keyProperty = "Cid",keyColumn = "cid")
    int insertComment(Comment comment);

    @Select("Select c.cid, c.uid, c.pinglun, u.u_username from Comment c ,User u " +
            "where c.imgid=#{Imgid} and c.uid=u.u_id")
    ArrayList<Comment_name> getImgAllComment(@Param("Imgid")int imgid);

    @Select("Select c.cid, c.uid, c.pinglun, u.u_username from Comment c ,User u " +
            "where c.uid=#{uid} and c.uid=u.u_id")
    ArrayList<Comment_name> getUserAllComment(@Param("uid")int uid);

    @Delete("delete from Comment where cid=#{cid}")
    int deleteSingleComment(@Param("cid") int cid);

    @Select("SELECT LAST_INSERT_ID();")
    int lastInsertCid();
}
