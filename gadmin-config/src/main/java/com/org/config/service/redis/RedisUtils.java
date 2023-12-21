package com.org.config.service.redis;

public interface RedisUtils {
    public void set(final String key, Object value);

    // 读取缓存
    public <T> T get(final String key, Class<T> targetType);
}
