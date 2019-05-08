package com.company.heartbeatsignal.dao.nosql.redis;

import com.company.heartbeatsignal.dao.nosql.CacheStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Liquid
 * @类名： SpringRedisCacher
 * @描述：
 * @date 2019/4/13
 */
@Component("CacheStrategy")
public class RedisStrategy implements CacheStrategy {

    @Qualifier("stringRedisTemplate")
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void appendString(String key, String append) {
        stringRedisTemplate.opsForValue().append(key, append);
    }

    @Override
    public void setStringWithTimeOut(String key, String value, long time) {
        stringRedisTemplate.opsForValue().set(key, value, time, TimeUnit.MILLISECONDS);
    }

    @Override
    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void deleteString(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public boolean hasKey(String key) {

        return stringRedisTemplate.hasKey(key);

    }

}
