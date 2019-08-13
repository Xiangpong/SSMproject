package com.pong.portal.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    private static Gson gson =null;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    public static String toJson(Object object){
        return gson.toJson(object);
    }

    public static <T> T formJson(Class<T> tClass,String json){
        return gson.fromJson(json,tClass);
    }
}
