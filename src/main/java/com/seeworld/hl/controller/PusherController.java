package com.seeworld.hl.controller;

import com.seeworld.hl.domain.Pusher;
import com.seeworld.hl.service.PusherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PusherController {
    private PusherService pusherService;

    @Autowired
    PusherController(PusherService pusherService) {
        this.pusherService = pusherService;
    }

    @RequestMapping(value = "/addPusherController")
    public String addPusher(HttpServletRequest request, Model model) throws Exception {
        System.out.println("now addPusher ");
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String desc = request.getParameter("desc");
        String phone = request.getParameter("phone");
        Pusher pusher = new Pusher();
        pusher.set(name, pwd, phone, desc, username);
        pusherService.addPusher(pusher);
        return "index";
    }
    @RequestMapping(value = "/PusherLoginController")
    public String pusherLogin(HttpServletRequest request, Model model) throws Exception {
        System.out.println("now pusherLogin");
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        System.out.println("username="+username);
        System.out.println("password="+password);
        boolean login = pusherService.login(username, password);
        if (!login) {
            System.out.println("login="+login);
            model.addAttribute("error", "用户名密码错误");
            return "login";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("Username", username);
            model.addAttribute("userName", username);
            return "index";
        }
    }
}
