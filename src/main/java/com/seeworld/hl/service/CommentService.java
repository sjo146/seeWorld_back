package com.seeworld.hl.service;

import com.seeworld.hl.domain.Comment;
import com.seeworld.hl.domain.Comment_name;

import java.util.ArrayList;

public interface CommentService {

    int insertComment(Comment comment);

    ArrayList<Comment_name> getImgAllComment(int imgid);

    ArrayList<Comment_name> getUserAllComment(int uid);

    int deleteSingleComment(int cid);

    int lastInsertCid();
}
