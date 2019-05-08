package com.seeworld.hl.controller;

import com.seeworld.hl.domain.Pusher;
import com.seeworld.hl.service.PusherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class addPusherController {
    private PusherService pusherService;
    @Autowired
    addPusherController(PusherService pusherService){
        this.pusherService=pusherService;
    }
    @RequestMapping(value = "/addPusherController")

    public String addPusher(HttpServletRequest request, Model model) throws Exception
    {
        System.out.println("now addPusher ");
        String username=request.getParameter("username");
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        String desc=request.getParameter("desc");
        String phone=request.getParameter("phone");
        Pusher pusher=new Pusher();
        pusher.set(name,pwd,phone,desc,username);
        pusherService.addPusher(pusher);

        return"index";
    }
}
