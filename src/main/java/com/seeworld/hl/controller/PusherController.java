package com.seeworld.hl.controller;

import com.seeworld.hl.domain.ImgMsg;
import com.seeworld.hl.domain.Pusher;
import com.seeworld.hl.service.ImgMsgService;
import com.seeworld.hl.service.PusherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class PusherController {
    private PusherService pusherService;
    private ImgMsgService imgMsgService;

    @Autowired
    PusherController(PusherService pusherService,ImgMsgService imgMsgService) {
        this.pusherService = pusherService;
        this.imgMsgService=imgMsgService;
    }

    @RequestMapping(value = "/addPusherController")
    public String addPusher(HttpServletRequest request, Model model) throws Exception {
        System.out.println("now addPusher ");
        String username = request.getParameter("user");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String desc = request.getParameter("desc");
        String phone = request.getParameter("phone");
        Pusher pusher = new Pusher();
        pusher.set(name, pwd, phone, desc, username);
        int result=pusherService.addPusher(pusher,request);
        if(result==0)
        {
            model.addAttribute("error", "用户名密码错误");
            return "register";
        }
        return "allPic";
    }
    @RequestMapping(value = "/PusherLoginController")
    public String pusherLogin(HttpServletRequest request, Model model) throws Exception {
        System.out.println("now pusherLogin");
        String username = request.getParameter("user");
        String password = request.getParameter("pwd");
        System.out.println("username="+username);
        System.out.println("password="+password);
        boolean login = pusherService.login(username, password,request);
        if (!login) {
            System.out.println("login="+login);
            model.addAttribute("error", "用户名密码错误");
            return "login";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("Username", username);
            model.addAttribute("userName", username);
            System.out.println("now getAllPic)");
            int pid=(int)(session.getAttribute("PID"));
            ArrayList<ImgMsg> list=imgMsgService.getAllPicture(pid);
            model.addAttribute("PicList",list);
            return "allPic";
        }
    }
    @RequestMapping(value = "/findPusherInfo")
    public String findPusherInfo(HttpServletRequest request, Model model) throws Exception {
        HttpSession session=request.getSession();
        int PId=(int)(session.getAttribute("PID"));
        Pusher pusher=pusherService.findPusherInfo(PId);
        model.addAttribute("pusher",pusher);
        return "pusherInfo";
    }
    @RequestMapping(value = "/updatePusherInfo")
    public String updatePusherInfo(HttpServletRequest request, Model model) throws Exception {
        int pid=Integer.valueOf(request.getParameter("id"));
        String name=request.getParameter("name");
        String username=request.getParameter("username");
        String phone=request.getParameter("phone");
        String desc=request.getParameter("desc");
        Pusher pusher=new Pusher();
        pusher.setPId(pid);
        pusher.setPDesc(desc);
        pusher.setPName(name);
        pusher.setPUsername(username);
        pusher.setPPhone(phone);
        pusher=pusherService.updatePusher(pusher);
        model.addAttribute("pusher",pusher);
        return "pusherInfo";
    }
}
