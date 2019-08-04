package com.pong.controller;

import EasyUIPojo.ResponseJsonResult;
import com.pong.pojo.Product;
import com.pong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品管理控制层
 */

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("product_list")
    public String listProduct(){
        return "product_list";
    }

    @RequestMapping("/product_save")
    @ResponseBody
    public ResponseJsonResult saveProduct(Product product){
        ResponseJsonResult responseJsonResult = productService.saveProduct(product);
        return  responseJsonResult;
    }
}
