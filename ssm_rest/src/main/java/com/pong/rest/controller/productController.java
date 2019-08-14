package com.pong.rest.controller;

import EasyUIPojo.ResponseJsonResult;
import com.pong.rest.service.productCategoryService;
import com.pong.rest.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.RestCategory2;

@Controller
@RequestMapping("/rest")
public class productController {

    @Autowired
    productService productService;

    @Autowired
    productCategoryService productCategoryService;

    @RequestMapping("product/list")
    @ResponseBody
    public ResponseJsonResult getProduct(Short category_id){
        ResponseJsonResult responseJsonResult = productService.getProduct(category_id);
        return responseJsonResult;
    }


}
