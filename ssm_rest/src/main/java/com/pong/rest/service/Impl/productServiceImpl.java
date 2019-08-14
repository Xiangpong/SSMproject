package com.pong.rest.service.Impl;

import EasyUIPojo.ResponseJsonResult;
import com.pong.mapper.ProductMapper;
import com.pong.pojo.Product;
import com.pong.pojo.ProductExample;
import com.pong.rest.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.RestProduct;

import java.util.ArrayList;
import java.util.List;

@Service
public class productServiceImpl implements productService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public ResponseJsonResult getProduct(Short category_id) {

        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria  = productExample.createCriteria();
        criteria.andCategoryIdEqualTo(category_id);
        List<Product> productsList = productMapper.selectByExample(productExample);

        List<RestProduct> restProducts = new ArrayList<>();

        for (int i=0;i<productsList.size();i++){
            RestProduct restProduct = new RestProduct();
            Product product = productsList.get(i);

            restProduct.setId(product.getId());
            restProduct.setAuthor(product.getProductBelongs());
            restProduct.setImg(product.getImage());
            restProduct.setPrice(product.getPrice());
            restProduct.setName(product.getName());
            restProduct.setDescription(product.getDescription());

            restProducts.add(restProduct);
        }

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setList(restProducts);
        return responseJsonResult;
    }
}
