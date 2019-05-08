package com.seeworld.hl.service.Impl;

import com.seeworld.hl.dao.ImgMsgMapper;
import com.seeworld.hl.domain.ImgMsg;
import com.seeworld.hl.service.DisplayAllViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DisplayAllViewServiceImpl implements DisplayAllViewService {
    @Autowired
    private ImgMsgMapper imgMsgMapper;
    /*
    public DisplayAllViewServiceImpl(ImgMsgMapper imgMsgMapper){
        this.imgMsgMapper=imgMsgMapper;
    }

     */

    @Override
    public ArrayList<ImgMsg> getAllImgMsg() {
        return imgMsgMapper.findAllImgMsg();
    }
}
