package com.seeworld.hl.service;

import com.seeworld.hl.domain.ImgMsg;

import java.util.ArrayList;

public interface ImgMsgService {
    public int addImg(ImgMsg img,int pid);
    ArrayList<ImgMsg> getAllPicture(int pid);
    public byte[] SaveImage(String path);
    boolean deleteImg(int imgID);
    ImgMsg getImgByImgId(int id);
    ImgMsg updateImg(ImgMsg imgMsg);
    String base64StringToImage(String base64String,int id);
}
