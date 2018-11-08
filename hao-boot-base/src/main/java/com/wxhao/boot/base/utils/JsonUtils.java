package com.wxhao.boot.base.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @author wxhao
 * @date 2018/4/27
 */
@Slf4j
public class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (IOException e) {
            log.error(String.format("obj=[%s]", obj.toString()), e);
        }
        return null;
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        if (json == null) {
            return null;
        }
        try {
            return MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            log.error(String.format("json=[%s]", json), e);
        }
        return null;
    }

    public static JsonNode readTree(String json){
        try {
            return MAPPER.readTree(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> toListfromJson(String json, Class<T> clazz) {
        if (json == null) {
            return null;
        }
        try {
            List<T> collection = MAPPER.readValue(json, getCollectionType(List.class, clazz));
            return collection;
        } catch (IOException e) {
            log.error(String.format("json=[%s]", json), e);
        }
        return null;
    }

    public static <T> Collection<T> fromJson(String json, Class<? extends Collection> collectionClazz, Class<T> clazz) {
        if (json == null) {
            return null;
        }
        try {
            Collection<T> collection = MAPPER.readValue(json, getCollectionType(collectionClazz, clazz));
            return collection;
        } catch (IOException e) {
            log.error(String.format("json=[%s]", json), e);
        }
        return null;
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

}
