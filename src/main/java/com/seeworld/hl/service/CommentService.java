package com.seeworld.hl.service;

import com.seeworld.hl.domain.Comment;
import com.seeworld.hl.domain.Comment_name;
import com.seeworld.hl.domain.ImgMsg;

import java.util.ArrayList;

public interface CommentService {

    int insertComment(Comment comment);

    ArrayList<Comment_name> getImgAllComment(int imgid);

    ArrayList<Comment_name> getUserAllComment(int uid);

    int deleteSingleComment(int cid);

    int lastInsertCid();

    ArrayList<ImgMsg> findByUid(int uid);

    ArrayList<Comment> findByImgAndUid(int imgid,int uid);
}
