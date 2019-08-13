package com.pong.rest.controller;

import com.pong.rest.service.productCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.RestCategory;

@Controller
@RequestMapping("/rest")
public class productCategoryController {

    @Autowired
    productCategoryService productCategoryService;

    @RequestMapping("productCategory/list")
    @ResponseBody
    public RestCategory getCategory(){

        RestCategory restCategory = productCategoryService.getCategory();
        return restCategory;
    }

}
