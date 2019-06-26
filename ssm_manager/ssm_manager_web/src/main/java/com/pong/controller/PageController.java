package com.pong.controller;
/**
 * 页面控制管理器
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String requestPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/")
    public String requestIndex(){
        return "index";
    }
}
