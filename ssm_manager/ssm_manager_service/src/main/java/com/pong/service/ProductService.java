package com.pong.service;

import EasyUIPojo.EasyGrid;
import EasyUIPojo.ResponseJsonResult;
import com.pong.pojo.Product;

public interface ProductService {

    ResponseJsonResult saveProduct(Product product);

    EasyGrid listProduct(int pages,int rows);

    ResponseJsonResult editorProduct(Product product);

    ResponseJsonResult removeProduct(Short id);
}
