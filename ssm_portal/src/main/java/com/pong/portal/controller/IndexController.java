package com.pong.portal.controller;

import com.pong.portal.service.CategoryService;
import com.pong.portal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.RestCategory;
import pojo.RestProduct;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;


    @RequestMapping("/")
    public String toIndex(ModelMap modelMap){
        RestCategory category = categoryService.getCategory();
        modelMap.addAttribute("category",category);

        return "index";
    }


    @RequestMapping("/product/list")

    public String toProduct(ModelMap modelMap,@RequestParam(value = "category_id",defaultValue = "0")short category_id){
         List<RestProduct> list = productService.getProduct(category_id);
         modelMap.addAttribute("product",list);

        return "product";
    }
}
