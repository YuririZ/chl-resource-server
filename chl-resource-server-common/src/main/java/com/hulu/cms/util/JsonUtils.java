package com.hulu.cms.util;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author DiCaprito
 */
@Log4j2
public class JsonUtils {

    /**
     * @description 字段功能描述
     * @value value:mapper
     */
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * json转map
     * @param jsonStr json
     * @return map
     * @author DiCaprito
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> toMap(String jsonStr) {
        Map<String, Object> map = null;
        try {
            map = mapper.readValue(jsonStr, Map.class);
        } catch (Exception e) {
            log.error("[Json]：error：{}", e.getMessage());
        }
        return map;
    }

    /**
     * json 转list
     * @param jsonStr json串
     * @return list
     * @author DiCaprito
     */
    @SuppressWarnings({"unchecked" })
    public static List toList(String jsonStr) {
        List list = null;
        try {
            list = mapper.readValue(jsonStr, List.class);
        } catch (Exception e) {
            log.error("[Json]：error：{}", e.getMessage());
        }
        return list;
    }

    /**
     * 对象转json
     * @param obj 对象
     * @return json string
     * @author DiCaprito
     */
    public static String toJson(Object obj) {
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.error("[Json]：error：{}", e.getMessage());
        }
        return jsonStr;
    }

    /**
     * json转对象
     * @param json json
     * @param clazz 对象class
     * @param <T> 对象
     * @return 对象
     */
    public static <T> T toBean(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json) || null == clazz) {
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T) json : mapper.readValue(json, clazz);
        }
        catch (Exception e) {
            log.error("[Json]：error：{}", e.getMessage());
            return null;
        }
    }

    /**
     * json转对象
     * @param json json
     * @param typeReference typeReference
     * @param <T> 对象
     * @return 对象
     */
    public static <T> T toBean(String json, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(json) || null == typeReference) {
            return null;
        }
        try {
            return (T) (typeReference.getType().equals(String.class) ? json : mapper.readValue(json, typeReference));
        }
        catch (Exception e) {
            log.error("[Json]：error：{}", e.getMessage());
            return null;
        }
    }

    /**
     * json转对象
     * @param json json
     * @param collectionClazz 集合class
     * @param elementClazzes 泛型class
     * @param <T> 对象
     * @return 对象
     * @author DiCaprito
     */
    public static <T> T toCollection(String json, Class<?> collectionClazz, Class<?>... elementClazzes) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClazz, elementClazzes);
        try {
            return mapper.readValue(json, javaType);
        }
        catch (Exception e) {
            log.error("[Json]：error：{}", e.getMessage());
            return null;
        }
    }

    /**
     * Object转对象
     *
     * @param object
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toBean(Object object, Class<T> clazz){
        if (null == object || null == clazz) {
            return null;
        }
        try {
            return mapper.convertValue(object, clazz);
        }
        catch (Exception e) {
            log.error("[Json]：error：{}", e.getMessage());
            return null;
        }
    }

    /**
     * ObjectList转对象List
     *
     * @param objectList
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(List<Object> objectList, Class<T> clazz){
        if (CollectionUtils.isEmpty(objectList) || clazz == null){
            return null;
        }
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, clazz);
            return mapper.convertValue(objectList, javaType);
        } catch (Exception e){
            log.error("[Json]：error：{}", e.getMessage());
            return null;
        }
    }
}
