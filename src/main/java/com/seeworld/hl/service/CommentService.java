package com.seeworld.hl.service;

import com.seeworld.hl.domain.Comment;

import java.util.ArrayList;

public interface CommentService {

    int insertComment(Comment comment);

    ArrayList<Comment> getImgAllComment(int imgid);

    ArrayList<Comment> getUserAllComment(int uid);

    int deleteSingleComment(int cid);
}
