package com.org.utility.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.config.service.json.JsonUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Service;

/**
 * @author: Yuallart
 * @version: 1.0.0
 * @since: 1.0.0
 * @date: 2023-12-21
 * @description: json序列化工具类的默认实现
 */
@Service("common-json")
public class JsonUtilsMapper implements JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 在反序列化时忽略在json字符串中存在，而在java类中不存在的属性
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            // handle the exception or rethrow it
            throw new RuntimeException("Error writing object to JSON", e);
        }
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            // handle the exception or rethrow it
            throw new RuntimeException("Error reading object from JSON", e);
        }
    }

    /**
     * 用来防止JSON实体中潜在的XSS攻击，安全地输出JSON字符串
     *
     * @param obj
     * @return {@code String}
     */
    public String toSecureJson(Object obj) {
        String jsonString = toJson(obj);
        return StringEscapeUtils.escapeJson(jsonString);
    }
}
