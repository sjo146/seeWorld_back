package com.seeworld.hl.service;

import com.seeworld.hl.domain.Zan;


public interface ZanService {
    int insertOriginalZan(Zan zan);

    Zan findZanmsg(int id);

    int  updateZanState(Zan zan);
}
