package com.pong.controller;

import EasyUIPojo.EasyGrid;
import EasyUIPojo.ResponseJsonResult;
import com.pong.pojo.Product;
import com.pong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品管理控制层
 */

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/product/list")
    @ResponseBody
    public EasyGrid listProduct(@RequestParam(value = "page",defaultValue = "1" )int page, @RequestParam(value = "rows",defaultValue = "10")int rows){

        EasyGrid easyGrid = productService.listProduct(page,rows);
        return easyGrid;
    }

    @RequestMapping("/product_save")
    @ResponseBody
    public ResponseJsonResult saveProduct(Product product){
        ResponseJsonResult responseJsonResult = productService.saveProduct(product);
        return  responseJsonResult;
    }

    @RequestMapping("/product_editor")
    @ResponseBody
    public ResponseJsonResult editorProduct(Product product){
        ResponseJsonResult responseJsonResult = productService.editorProduct(product);
        return  responseJsonResult;
    }

    @RequestMapping("/product_remove")
    @ResponseBody
    public ResponseJsonResult removeProduct(Short id){
        ResponseJsonResult responseJsonResult = productService.removeProduct(id);

        return responseJsonResult;
    }
}
