package com.company.heartbeatsignal.dao.nosql;

/**
 * @author Liquid
 * @类名： SpringRedisCacheable
 * @描述：
 * @date 2019/4/13
 */
public interface CacheStrategy {

    void setString(String key, String value);

    void appendString(String key, String append);

    void setStringWithTimeOut(String key, String value, long time);

    String getString(String key);

    void deleteString(String key);

    boolean hasKey(String key);

}
