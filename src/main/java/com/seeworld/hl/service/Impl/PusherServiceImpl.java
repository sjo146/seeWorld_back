package com.seeworld.hl.service.Impl;

import com.seeworld.hl.dao.PusherMapper;
import com.seeworld.hl.domain.Pusher;
import com.seeworld.hl.service.PusherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class PusherServiceImpl implements PusherService {
    PusherMapper pusherMapper;
    @Autowired
    PusherServiceImpl(PusherMapper pusherMapper) {
        this.pusherMapper = pusherMapper;
    }

    @Override
    public int addPusher(Pusher p,HttpServletRequest request) {
        System.out.println("now addPusher");
        if(pusherMapper.queryByUsername(p.getPUsername())!=null)
            return 0;
        else
        {
            int result=pusherMapper.insertPusher(p);
            Pusher pusher=pusherMapper.queryByUsername(p.getPUsername());
            HttpSession session = request.getSession();
            session.setAttribute("PID", pusher.getPId());
            return result;
        }
    }
    @Override
    public boolean login(String username, String password, HttpServletRequest request) {
        System.out.println("now login");
        boolean result = true;
        Pusher p=pusherMapper.queryPusherLogin(username,password);
        if (p==null) {
            result = false;
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("PID", p.getPId());
            result = true;
        }
        return result;
    }

    @Override
    public Pusher findPusherInfo(int pid) {
        Pusher p=pusherMapper.selectByPId(pid);
        return p;
    }

    @Override
    public Pusher updatePusher(Pusher p) {
        pusherMapper.updatePusher(p);
        return pusherMapper.selectByPId(p.getPId());
        //return null;
    }
}
