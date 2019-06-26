package com.pong.controller;

import EasyUIPojo.EasyUITree;
import com.pong.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类管理控制器
 */
@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {
    /*
    根据id返回数据列表
     */
    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITree> getProductCategoryByParentId(@RequestParam(value = "id",defaultValue = "0")short parentId){
        List<EasyUITree> easyUITrees = productCategoryService.findProductCategoryListByParentId(parentId);
        return easyUITrees;
    }
}
