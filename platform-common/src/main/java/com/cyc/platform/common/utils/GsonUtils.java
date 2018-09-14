package com.cyc.platform.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by huzuxing on 2017/9/18.
 */
public class GsonUtils {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().setVersion(1.0).create();

    private static final Gson gsonExcludeField = new GsonBuilder()
            .setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().setVersion(1.0).create();

    private GsonUtils() {}

    public static String toGson(Object object) {
        return gson.toJson(object);
    }
    public static String toGsonExcludeFields(Object object) {
        return gsonExcludeField.toJson(object);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJsonExcludeFields(String json, Type typeOfT) {
        return gsonExcludeField.fromJson(json, typeOfT);
    }

    public static <T> T fromJsonExcludeFields(String json, Class<T> classOfT) {
        return gsonExcludeField.fromJson(json, classOfT);
    }

}
