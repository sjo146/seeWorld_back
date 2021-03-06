package com.seeworld.hl.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.seeworld.hl.domain.Comment;
import com.seeworld.hl.domain.ImgMsg;
import com.seeworld.hl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/getAllCommentByimgid", method = RequestMethod.POST)
    JSONArray getAllCommentByimgid(@RequestBody JSONObject json) {
        System.out.println("得到所有评论");
        int imgid = json.getInteger("imgid");
        JSONArray jar = new JSONArray();
        System.out.println(commentService.getImgAllComment(imgid).size());

        if (commentService.getImgAllComment(imgid).size() != 0)
            jar.add(commentService.getImgAllComment(imgid));
        return jar;
    }

    @ResponseBody
    @RequestMapping(value = "/writeAComment", method = RequestMethod.POST)
    JSON writeAComment(@RequestBody JSONObject json) {
        System.out.println("写评论");
        int imgid = json.getInteger("imgid");
        int uid = json.getInteger("uid");
        String comment = json.getString("comment");
        Comment co = new Comment();
        co.setImgid(imgid);
        co.setPinglun(comment);
        co.setUid(uid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", commentService.insertComment(co));
        jsonObject.put("cid", commentService.lastInsertCid());
        return jsonObject;
    }

    @RequestMapping(value = "/getMyCommentPic", method = RequestMethod.POST)
    public @ResponseBody
    JSON getMyCommentPic(@RequestBody String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        int uid = Integer.valueOf(jsonObject.getString("uid"));
        System.out.println("uid="+uid);
        JSONArray Jay=new JSONArray();
        JSONObject result = new JSONObject();
        ArrayList<ImgMsg> imgMsgs = commentService.findByUid(uid);
        System.out.println("size="+imgMsgs.size());
        for(int i=0;i<imgMsgs.size();i++){
            Jay.add(imgMsgs.get(i));
            System.out.println(imgMsgs.get(i).getImgResourceName());
            //System.out.println(imgMsgs.get(i).getImgDesc());
        }
        return Jay;

    }

    @RequestMapping(value = "/getMyComment", method = RequestMethod.POST)
    public @ResponseBody
    JSONArray getMyComment(@RequestBody JSONObject json) {
        System.out.println("now getMyComment");
        int imgid = json.getInteger("imgid");
        int uid = json.getInteger("uid");
        System.out.println("imgid="+imgid);
        System.out.println("uid="+uid);
        JSONArray Jay = new JSONArray();
        if (commentService.findByImgAndUid(imgid,uid).size() != 0)
            Jay.add(commentService.findByImgAndUid(imgid,uid));
        return Jay;
    }

}
