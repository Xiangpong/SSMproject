package com.pong.rest.service;

import com.pong.pojo.ProductCategory;
import pojo.RestCategory;
import pojo.RestCategory2;

public interface productCategoryService {

     RestCategory getCategory();
    RestCategory2 getCategory(Short id);

}
