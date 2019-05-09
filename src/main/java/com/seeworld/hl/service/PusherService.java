package com.seeworld.hl.service;

import com.seeworld.hl.domain.Pusher;

public interface PusherService {
    int addPusher(Pusher p);
    public boolean login(String username, String password);
}
