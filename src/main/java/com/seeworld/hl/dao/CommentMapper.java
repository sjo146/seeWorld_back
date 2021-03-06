package com.seeworld.hl.dao;

import com.seeworld.hl.domain.Comment;
import com.seeworld.hl.domain.Comment_name;
import com.seeworld.hl.domain.ImgMsg;
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

    @Select("select distinct ImgMsg.* " +
            "from ImgMsg,Comment,User " +
            "where User.u_id=Comment.uid and ImgMsg.img_id=Comment.imgid and uid=#{uid}")
    ArrayList<ImgMsg> selectByUid(int uid);

    @Select("select*from Comment  " +
            "where imgid=#{imgid} and uid=#{uid} ")
    ArrayList<Comment> selectByImgidAndUid(int imgid,int uid);
}
