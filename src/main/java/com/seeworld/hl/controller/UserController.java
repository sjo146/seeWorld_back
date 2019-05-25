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
        boolean loginResult=userService.judgeLogin(username,pwd);
        JSONObject result = new JSONObject();
        result.put("loginResult",loginResult);
        JSONArray Jay=new JSONArray();
        Jay.add(result);
        return Jay;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    JSON register(@RequestBody String json) {
        JSONObject jsonObject=JSONObject.parseObject(json);
        String username=jsonObject.getString("UUsername");
        String pwd=jsonObject.getString("UPwd");
        User user=new User();
        user.setUUsername(username);
        user.setUPwd(pwd);
        int back=userService.addUser(user);
        String  registerResult=String.valueOf(back);
        JSONObject result = new JSONObject();
        result.put("registerResult",registerResult);
        JSONArray Jay=new JSONArray();
        Jay.add(result);
        return Jay;
    }

}
