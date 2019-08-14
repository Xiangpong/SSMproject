package com.pong.portal.service;

import pojo.RestProduct;

import java.util.List;

public interface ProductService {

    List<RestProduct> getProduct(Short category_id);
}
