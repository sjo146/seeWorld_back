package com.seeworld.hl.service.Impl;

import com.seeworld.hl.dao.ZanMapper;
import com.seeworld.hl.domain.Zan;
import com.seeworld.hl.service.ZanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZanServiceImpl implements ZanService {
    @Autowired
    ZanMapper zanMapper;
    @Override
    public int insertOriginalZan(Zan zan) {
        return zanMapper.insertOriginalZan(zan);
    }

    @Override
    public Zan findZanmsg(int id) {
        return zanMapper.findZanmsg(id);
    }

    @Override
    public int updateZanState(Zan zan) {
        return updateZanState(zan);
    }
}
