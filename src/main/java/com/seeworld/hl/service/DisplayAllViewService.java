package com.seeworld.hl.service;

import com.seeworld.hl.domain.ImgMsg;

import java.util.ArrayList;

public interface DisplayAllViewService {
    ArrayList<ImgMsg> getAllImgMsg();
    ArrayList<ImgMsg> getAllZanByUid(int uid);
}
