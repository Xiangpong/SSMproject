package com.pong.portal.service.Impl;

import EasyUIPojo.ResponseJsonResult;
import com.pong.portal.service.ProductService;
import com.pong.portal.util.GsonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pojo.RestProduct;
import util.HttpClientUtil;

import java.io.IOException;
import java.util.List;

@Service
public class  ProductServiceImpl implements ProductService {

    @Value("${REST_URL}")
    private String REST_URL;

    @Value("${REST_PRO_URL}")
    private String REST_PRO_URL;
    @Override
    public  List<RestProduct> getProduct(Short category_id) {

        try{
            String jsonRes = HttpClientUtil.httpGet( REST_URL+REST_PRO_URL+"?category_id="+category_id);
            ResponseJsonResult responseJsonResult =GsonUtil.formJson(ResponseJsonResult.class,jsonRes);
            List<RestProduct> restProductsList = ( List<RestProduct>) responseJsonResult.getList();

            return restProductsList;


        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
}
