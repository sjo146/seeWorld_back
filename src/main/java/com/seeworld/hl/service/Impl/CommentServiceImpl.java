package com.seeworld.hl.service.Impl;

import com.seeworld.hl.dao.CommentMapper;
import com.seeworld.hl.domain.Comment;
import com.seeworld.hl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CommentServiceImpl  implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public ArrayList<Comment> getImgAllComment(int imgid) {
        return commentMapper.getImgAllComment(imgid);
    }

    @Override
    public ArrayList<Comment> getUserAllComment(int uid) {
        return commentMapper.getUserAllComment(uid);
    }

    /**
     * 删除一条评论
     * @param cid
     * @return
     */
    @Override
    public int deleteSingleComment(int cid) {
        return commentMapper.deleteSingleComment(cid);
    }
}
