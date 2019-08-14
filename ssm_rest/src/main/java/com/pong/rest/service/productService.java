package com.pong.rest.service;

import EasyUIPojo.ResponseJsonResult;

public interface productService {

    ResponseJsonResult getProduct(Short category_id);
}
