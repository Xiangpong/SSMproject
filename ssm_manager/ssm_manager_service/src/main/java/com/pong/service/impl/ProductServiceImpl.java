package com.pong.service.impl;

import EasyUIPojo.ResponseJsonResult;
import com.pong.mapper.ProductMapper;
import com.pong.pojo.Product;
import com.pong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public ResponseJsonResult saveProduct(Product product) {

        product.setStatus(1);
        productMapper.insert(product);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setStatus(200);


        return responseJsonResult;
    }
}
