package com.seeworld.hl.service;

import com.seeworld.hl.domain.Pusher;

import javax.servlet.http.HttpServletRequest;

public interface PusherService {
    int addPusher(Pusher p);
    public boolean login(String username, String password, HttpServletRequest request);
    Pusher findPusherInfo(int pid);
    Pusher updatePusher(Pusher p);
}
