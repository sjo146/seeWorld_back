package com.seeworld.hl.controller;

import com.seeworld.hl.service.DisplayAllViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DisplayAllViewController {
    private DisplayAllViewService displayAllViewService;
    @Autowired
    public DisplayAllViewController(DisplayAllViewService displayAllViewService){
        this.displayAllViewService=displayAllViewService;
    }

}
