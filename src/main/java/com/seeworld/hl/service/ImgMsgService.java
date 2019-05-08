package com.seeworld.hl.service;

import com.seeworld.hl.domain.ImgMsg;

public interface ImgMsgService {
    public int addImg(ImgMsg img);
    public byte[] SaveImage(String path);
    void base64StringToImage(String base64String);
}
