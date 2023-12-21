package com.org.redis.utils;

import com.org.config.service.redis.RedisUtils;
import com.org.exception.mapper.CommonException;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtilsImpl implements RedisUtils {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    // 设置缓存
    public void set(final String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 读取缓存
    public <T> T get(final String key, Class<T> targetType) {
        try {
            Object obj = redisTemplate.opsForValue().get(key);
            return targetType.cast(obj);
        } catch (ClassCastException e) {
            throw new CommonException("");
        }
    }

}
