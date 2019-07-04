package com.pong.service;


import EasyUIPojo.EasyUITree;
import EasyUIPojo.ResponseJsonResult;

import java.util.List;

public interface ProductCategoryService {

    List<EasyUITree> findProductCategoryListByParentId(Short parentId);

    ResponseJsonResult addCategory(Short parentId, String name);

    ResponseJsonResult updateCategory(Short id,String name);

    ResponseJsonResult deleteCategory(Short parentId,Short id);

}
