package com.seeworld.hl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.seeworld.hl.domain.User;
import com.seeworld.hl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class UserController {

    UserService userService;
    @Autowired
    UserController(UserService userService){
       this.userService=userService;
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    JSON login(@RequestBody String json) {
        JSONObject jsonObject=JSONObject.parseObject(json);
        String username=jsonObject.getString("UUsername");
        String pwd=jsonObject.getString("UPwd");
        User user=userService.judgeLogin(username,pwd);
        JSONObject result = new JSONObject();
        Boolean loginResult;
        if(user==null)loginResult=false;
        else
            {loginResult=true;
        result.put("uid",user.getUId());
        result.put("uusername",user.getUUsername());
        result.put("upersonal",user.getUPersonal());
        }
        result.put("loginResult",loginResult);
        return result;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    JSON register(@RequestBody String json) {
        JSONObject jsonObject=JSONObject.parseObject(json);
        String username=jsonObject.getString("UUsername");
        String pwd=jsonObject.getString("UPwd");
        User user=new User();
        user.setUUsername(username);
        user.setUPassword(pwd);
        user.setUPersonal("初来乍到，请多关照");
        int back=userService.addUser(user);
        String  registerResult=String.valueOf(back);
        JSONObject result = new JSONObject();
        result.put("registerResult",registerResult);
        JSONArray Jay=new JSONArray();
        Jay.add(result);
        return Jay;
    }

    @RequestMapping(value = "/changePwd", method = RequestMethod.POST)
    public @ResponseBody
    JSON changePwd(@RequestBody String json) {
        JSONObject jsonObject=JSONObject.parseObject(json);
        String newPwd=jsonObject.getString("new");
        String oldPwd=jsonObject.getString("old");
        int  uid=Integer.valueOf(jsonObject.getString("uid"));
        System.out.println(oldPwd);
        System.out.println(newPwd);
        System.out.println(uid);
        int registerResult=userService.changePwd(uid,oldPwd,newPwd);
        JSONObject result = new JSONObject();
        result.put("registerResult",registerResult);
        JSONArray Jay=new JSONArray();
        Jay.add(result);
        return Jay;
    }

    @RequestMapping(value = "/changeMine", method = RequestMethod.POST)
    public @ResponseBody
    JSON changeMine(@RequestBody String json) {
        JSONObject jsonObject=JSONObject.parseObject(json);
        String personal=jsonObject.getString("personal");
        String username=jsonObject.getString("username");
        int  uid=Integer.valueOf(jsonObject.getString("uid"));
        System.out.println(personal);
        System.out.println(username);
        System.out.println(uid);
        int registerResult=userService.changeMine(uid,username,personal);
        JSONObject result = new JSONObject();
        result.put("registerResult",registerResult);
        JSONArray Jay=new JSONArray();
        Jay.add(result);
        return Jay;
    }

}
