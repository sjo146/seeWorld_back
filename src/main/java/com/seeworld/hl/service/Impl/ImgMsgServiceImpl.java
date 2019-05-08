package com.seeworld.hl.service.Impl;

import com.seeworld.hl.dao.ImgMsgMapper;
import com.seeworld.hl.domain.ImgMsg;
import com.seeworld.hl.service.ImgMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgMsgServiceImpl implements ImgMsgService {

    private ImgMsgMapper imgMsgMapper;

    @Autowired
    ImgMsgServiceImpl(ImgMsgMapper imgMsgMapper) {
        this.imgMsgMapper = imgMsgMapper;
    }

    @Override
    public int addImg(ImgMsg img) {
        System.out.println("now addImg");
        return imgMsgMapper.addImg(img);
    }
}
