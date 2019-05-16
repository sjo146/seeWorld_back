package com.seeworld.hl.controller;

import com.seeworld.hl.domain.ImgMsg;
import com.seeworld.hl.service.ImgMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
@Controller

public class PictureController {
    private ImgMsgService imgMsgService;
    @Autowired
    PictureController(ImgMsgService imgMsgService) {
        this.imgMsgService = imgMsgService;
    }
    @RequestMapping(value = "/getAllPic")
    public String getAllPic(HttpServletRequest request, Model model) throws Exception {
        System.out.println("now getAllPic)");
        HttpSession session=request.getSession();
        int pid=(int)(session.getAttribute("PID"));
        ArrayList<ImgMsg> list=imgMsgService.getAllPicture(pid);
        model.addAttribute("PicList",list);
        return "allPic";
    }
    @RequestMapping(value = "/deletePic")
    public String deletePic(HttpServletRequest request, Model model) throws Exception {
        int imgID=Integer.valueOf(request.getParameter("imgID"));
        imgMsgService.deleteImg(imgID);
        HttpSession session=request.getSession();
        int pid=(int)(session.getAttribute("PID"));
        ArrayList<ImgMsg> list=imgMsgService.getAllPicture(pid);
        model.addAttribute("PicList",list);
        return "allPic";
    }


    @RequestMapping(value = "/lookPic")
    public String lookPic(HttpServletRequest request, Model model) throws Exception {
        int imgID=Integer.valueOf(request.getParameter("imgID"));
        ImgMsg imgMsg=imgMsgService.getImgByImgId(imgID);
        String path=imgMsgService.base64StringToImage(new String(imgMsg.getImgAssetName()),imgMsg.getImgId());
        model.addAttribute("imgMsg",imgMsg);
        model.addAttribute("imgPath",path);
        System.out.println(path);
        return "lookPic";
    }

    @RequestMapping(value = "/updatePic")
    public String updatePic(HttpServletRequest request, Model model) throws Exception {
        int imgID=Integer.valueOf(request.getParameter("id"));
        String title=request.getParameter("title");
        String desc=request.getParameter("desc");
        ImgMsg imgMsg=new ImgMsg();
        imgMsg.setImgId(imgID);
        imgMsg.setImgDesc(desc);
        imgMsg.setImgTitle(title);
       imgMsg=imgMsgService.updateImg(imgMsg);
        model.addAttribute("imgMsg",imgMsg);
        return "lookPic";
    }

}
