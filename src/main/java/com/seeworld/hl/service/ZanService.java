package com.seeworld.hl.service;

import com.seeworld.hl.domain.Zan;

import java.util.ArrayList;


public interface ZanService {
    int insertOriginalZan(Zan zan);

    Zan findZanmsg(int id,int uis);

    int updateZanState(Zan zan);

    ArrayList<Zan> getAllZan(int uid);
}
