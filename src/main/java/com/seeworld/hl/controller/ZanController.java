package com.seeworld.hl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.seeworld.hl.domain.Zan;
import com.seeworld.hl.service.ZanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class ZanController {
    @Autowired
    ZanService zanService;

    /**
     * 前端传来图片号，这里传输点赞情况
     * @param json
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getZanbyImgIDandUid", method = RequestMethod.POST)
    JSONArray getZanbyImgID(@RequestBody JSONObject json) {
        int imgid = json.getInteger("imgid");
        int uid=json.getInteger("uid");
        JSONArray jar = new JSONArray();
        jar.add(zanService.findZanmsg(imgid,uid));
        return jar;
    }

    @ResponseBody
    @RequestMapping(value = "/updatezan", method = RequestMethod.POST)
    JSON updatezan(@RequestBody JSONObject json) {
        int imgid = json.getInteger("imgid");
        int uid=json.getInteger("uid");
        Boolean iszan=json.getBoolean("iszan");
        Zan zan=new Zan();
        zan.setUid(uid);
        zan.setImagid(imgid);
        zan.setIszan(iszan);
        int x=zanService.updateZanState(zan);
        JSONObject jo=new JSONObject();
        if(x==1)jo.put("msg","ok");
        else jo.put("msg","error");
        return jo;
    }

    @ResponseBody
    @RequestMapping(value = "/getAllZans", method = RequestMethod.POST)
    JSON getAllZans(@RequestBody JSONObject json) {
        int uid=json.getInteger("uid");
       ArrayList<Zan> zans=zanService.getAllZan(uid);
       JSONArray jsonArray=new JSONArray();
       for(Zan zan:zans){
           jsonArray.add(zan);
       }
        return jsonArray;
    }

}
