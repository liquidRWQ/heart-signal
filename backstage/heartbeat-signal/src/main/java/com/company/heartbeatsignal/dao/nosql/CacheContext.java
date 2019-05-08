package com.company.heartbeatsignal.dao.nosql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Liquid
 * @类名： CacheContext
 * @描述：
 * @date 2019/4/13
 */
@Component("cacheContext")
public class CacheContext {

    @Autowired
    private CacheStrategy cacheStrategy;

    public void setString(String key, String value) {
        cacheStrategy.setString(key, value);
    }

    public void appendString(String key, String append) {
        cacheStrategy.appendString(key, append);
    }

    public void setStringWithTimeOut(String key, String value, long time) {
        cacheStrategy.setStringWithTimeOut(key, value, time);
    }

    public String getString(String key) {
        return cacheStrategy.getString(key);
    }

    public void deleteString(String key) {
        cacheStrategy.deleteString(key);
    }

    public boolean hasKey(String key) {
        return cacheStrategy.hasKey(key);
    }
}
