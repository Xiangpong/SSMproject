package com.pong.service.impl;

import EasyUIPojo.EasyUITree;
import EasyUIPojo.ResponseJsonResult;
import com.pong.mapper.ProductCategoryMapper;
import com.pong.pojo.ProductCategory;
import com.pong.pojo.ProductCategoryExample;
import com.pong.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductControllerServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    
    @Override
    public List<EasyUITree> findProductCategoryListByParentId(Short parentId) {
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<ProductCategory> productCategoriesList = productCategoryMapper.selectByExample(productCategoryExample);
        List<EasyUITree> easyUITrees = new ArrayList(productCategoriesList.size());

        for (ProductCategory productCategory:productCategoriesList) {
                EasyUITree easyUITree  = new EasyUITree();
                easyUITree.setId(productCategory.getId());
                easyUITree.setText(productCategory.getName());
                easyUITree.setAttributes(productCategory.getParentId()+"");
                easyUITree.setState(productCategory.getParentId()==0? "closed":"open");

                easyUITrees.add(easyUITree);
        }
        return easyUITrees;
    }

    @Override
    public ResponseJsonResult addCategory(Short parentId, String name) {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setParentId(parentId);
        productCategory.setName(name);

        productCategoryMapper.insert(productCategory);
        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setMsg(productCategory.getId()+"");

        return responseJsonResult;
    }

    @Override
    public ResponseJsonResult updateCategory(Short id, String name) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(name);
        productCategory.setId(id);

        productCategoryMapper.updateByPrimaryKey(productCategory);
        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setMsg(productCategory.getId()+"");

        return responseJsonResult;
    }

    @Override
    public ResponseJsonResult deleteCategory(Short parentId, Short id) {
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();

        if (parentId != 0){
            criteria.andIdEqualTo(id);

        }else {
            criteria.andIdEqualTo(id);
            ProductCategoryExample.Criteria criteriaL = productCategoryExample.createCriteria();
            criteriaL.andParentIdEqualTo(id);
            productCategoryExample.or(criteriaL);
        }

        productCategoryMapper.deleteByExample(productCategoryExample);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setStatus(200);
        responseJsonResult.setMsg("success");
        return responseJsonResult;
    }
}
