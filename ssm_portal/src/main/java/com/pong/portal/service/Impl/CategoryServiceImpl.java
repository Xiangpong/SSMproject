package com.pong.portal.service.Impl;

import com.pong.portal.service.CategoryService;
import com.pong.portal.util.GsonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pojo.RestCategory;
import util.HttpClientUtil;

import java.io.IOException;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Value("${REST_URL}")
    private String REST_URL;

    @Value("${REST_CAT_URL}")
    private String REST_CAT_URL;

    @Override
    public RestCategory getCategory() {

        try{
            String result = HttpClientUtil.httpGet( REST_URL+REST_CAT_URL);
            RestCategory restCategory = GsonUtil.formJson(RestCategory.class,result);

            return restCategory;


        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
}
