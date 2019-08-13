package com.pong.portal.controller;

import com.pong.portal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.RestCategory;

@Controller
public class IndexController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/")
    public String toIndex(ModelMap modelMap){
        RestCategory category = categoryService.getCategory();
        modelMap.addAttribute("category",category);

        return "index";
    }
}
