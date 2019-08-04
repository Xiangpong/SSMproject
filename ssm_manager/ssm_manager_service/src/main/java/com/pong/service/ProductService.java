package com.pong.service;

import EasyUIPojo.ResponseJsonResult;
import com.pong.pojo.Product;

public interface ProductService {

    ResponseJsonResult saveProduct(Product product);

}
