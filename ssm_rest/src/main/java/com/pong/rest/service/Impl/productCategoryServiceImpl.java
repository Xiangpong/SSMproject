package com.pong.rest.service.Impl;

import com.pong.mapper.ProductCategoryMapper;
import com.pong.pojo.ProductCategory;
import com.pong.pojo.ProductCategoryExample;
import com.pong.rest.service.productCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.RestCategory;
import pojo.RestCategory2;

import java.util.ArrayList;
import java.util.List;

@Service
public class productCategoryServiceImpl implements productCategoryService {


    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Override
    public RestCategory getCategory() {
        RestCategory restCategory = new RestCategory();
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        //获取父级分类列表
        criteria.andParentIdEqualTo((short)0);
        List<ProductCategory> productCategoryList = productCategoryMapper.selectByExample(productCategoryExample);
        List<RestCategory.CategoriesBean> categories = new ArrayList<>();
        for (int i=0;i<productCategoryList.size();i++){
            RestCategory.CategoriesBean categoriesBean = new RestCategory.CategoriesBean();
            ProductCategory productCategory = productCategoryList.get(i);
            categoriesBean.setName(productCategory.getName());
            categoriesBean.setCat_id(productCategory.getId()+"");
            //获取父类的子分类
            List<RestCategory.CategoriesBean.SubCategoriesBean> sub_categoriesList = getSubCategory(productCategory.getId());
            categoriesBean.setSub_categories(sub_categoriesList);
            categories.add(categoriesBean);
        }
        restCategory.setCategories(categories);
        return restCategory;
    }

    @Override
    public RestCategory2 getCategory(Short id) {
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andIdEqualTo(id);

        List<ProductCategory> productCategoryList = productCategoryMapper.selectByExample(productCategoryExample);
        RestCategory2 restCategory2 = new RestCategory2();
        for (int i=0;i<productCategoryList.size();i++){
            ProductCategory productCategory = productCategoryList.get(i);

            restCategory2.setId(productCategory.getId());
            restCategory2.setName(productCategory.getName());
        }
        return restCategory2;
    }

    private List<RestCategory.CategoriesBean.SubCategoriesBean> getSubCategory(Short id) {
        List<RestCategory.CategoriesBean.SubCategoriesBean> list = new ArrayList<>();
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<ProductCategory> productCategories = productCategoryMapper.selectByExample(productCategoryExample);
        for (int i=0;i<productCategories.size();i++){
            RestCategory.CategoriesBean.SubCategoriesBean subCategoriesBean = new RestCategory.CategoriesBean.SubCategoriesBean();
            ProductCategory productCategory = productCategories.get(i);
            subCategoriesBean.setCat_id(productCategory.getId()+"");
            subCategoriesBean.setName(productCategory.getName());
            list.add(subCategoriesBean);
        }

        return list;
    }
}
