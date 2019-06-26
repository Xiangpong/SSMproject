package com.pong.service;


import EasyUIPojo.EasyUITree;

import java.util.List;

public interface ProductCategoryService {

    List<EasyUITree> findProductCategoryListByParentId(Short parentId);
}
