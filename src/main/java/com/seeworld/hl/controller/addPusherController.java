package com.seeworld.hl.controller;

import com.seeworld.hl.service.PusherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class addPusherController {
    private PusherService pusherService;
    @RequestMapping(value = "/addPusherController")

    public String addPusher(HttpServletRequest request, Model model) throws Exception
    {
        System.out.println("now addPusher ");
        int id=Integer.valueOf(request.getParameter("id"));
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        String desc=request.getParameter("desc");
        String phone=request.getParameter("phone");
        return"index";
    }
}
