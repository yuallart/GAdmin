package com.org.config.service.json;

public interface JsonUtils {

    String toJson(Object obj);

    String toSecureJson(Object obj);

    <T> T fromJson(String json, Class<T> clazz);

}
