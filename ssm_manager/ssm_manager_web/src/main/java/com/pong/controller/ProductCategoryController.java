package com.pong.controller;

import EasyUIPojo.EasyUITree;
import EasyUIPojo.ResponseJsonResult;
import com.pong.pojo.ProductCategoryExample;
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


    /*
    添加分类
     */


    @RequestMapping("/add")
    @ResponseBody
    public ResponseJsonResult addCategory(Short parentId,String name){
        ResponseJsonResult responseJsonResult = productCategoryService.addCategory(parentId,name);
        return responseJsonResult;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseJsonResult updateCategory(Short id,String name){
        ResponseJsonResult responseJsonResult = productCategoryService.updateCategory(id,name);
        return responseJsonResult;
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseJsonResult deleteCategory(Short parentId,Short id) {

        ResponseJsonResult responseJsonResult = productCategoryService.deleteCategory(parentId,id);
        return responseJsonResult;

    }

}
