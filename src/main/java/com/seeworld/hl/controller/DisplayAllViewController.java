package com.seeworld.hl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.seeworld.hl.domain.ImgMsg;
import com.seeworld.hl.service.DisplayAllViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class DisplayAllViewController {
    @Autowired
    private DisplayAllViewService displayAllViewService;

  /*
    public DisplayAllViewController(DisplayAllViewService displayAllViewService) {
        this.displayAllViewService = displayAllViewService;
    }

   */

    @ResponseBody
    @RequestMapping(value = "/getAllImgMsg", method = RequestMethod.GET)
    public JSON getAllImgMsg() {
        JSONArray Jay=new JSONArray();

        JSONObject result = new JSONObject();
        ArrayList<ImgMsg> imgMsgs = displayAllViewService.getAllImgMsg();
        for(int i=0;i<imgMsgs.size();i++){
            Jay.add(imgMsgs.get(i));
            System.out.println(imgMsgs.get(i).getImgDesc());
        }

        return Jay;
    }
}
