package com.pong.service.impl;

import EasyUIPojo.EasyUITree;
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
                easyUITree.setState(productCategory.getParentId()==0? "closed":"open");

                easyUITrees.add(easyUITree);
        }
        return easyUITrees;
    }
}
