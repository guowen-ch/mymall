package com.gwen.mall.redis.redisservice;

import java.util.Map;

/**
 * Description：
 * Created By guowen
 */
public interface IRedisService {
    // 加入元素
    void setValue(String key, Map<String, Object> value);
    // 加入元素
    void setValue(String key, String value);
    // 加入元素
    void setValue(String key, Object value);
    // 获取元素
    Object getMapValue(String key);
    // 获取元素
    Object getValue(String key);

}
