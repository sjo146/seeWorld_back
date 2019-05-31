package com.seeworld.hl.service.Impl;

import com.seeworld.hl.dao.CommentMapper;
import com.seeworld.hl.domain.Comment;
import com.seeworld.hl.domain.Comment_name;
import com.seeworld.hl.domain.ImgMsg;
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
    public ArrayList<Comment_name> getImgAllComment(int imgid) {
        return commentMapper.getImgAllComment(imgid);
    }

    @Override
    public ArrayList<Comment_name> getUserAllComment(int uid) {
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

    @Override
    public int lastInsertCid() {
        return commentMapper.lastInsertCid();
    }

    @Override
    public ArrayList<ImgMsg> findByUid(int uid) {
        ArrayList<ImgMsg> list=commentMapper.selectByUid(uid);
        System.out.println(list.get(0).getImgTitle());
        return list;
    }

    @Override
    public ArrayList<Comment> findByImgAndUid(int imgid, int uid) {
        ArrayList<Comment> list=commentMapper.selectByImgidAndUid(imgid,uid);
        System.out.println("size="+list.size());
        return list;
    }
}
