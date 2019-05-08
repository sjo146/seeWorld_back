package com.seeworld.hl.service.Impl;

import com.seeworld.hl.dao.PusherMapper;
import com.seeworld.hl.domain.Pusher;
import com.seeworld.hl.service.PusherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PusherServiceImpl implements PusherService {
    PusherMapper pusherMapper;
    @Autowired
    PusherServiceImpl(PusherMapper pusherMapper) {
        this.pusherMapper = pusherMapper;
    }

    @Override
    public int addPusher(Pusher p) {
        System.out.println("now addPusher");
        return pusherMapper.addPusher(p);
    }
}
