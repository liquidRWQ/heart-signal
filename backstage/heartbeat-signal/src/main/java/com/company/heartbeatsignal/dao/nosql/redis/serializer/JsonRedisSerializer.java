package com.company.heartbeatsignal.dao.nosql.redis.serializer;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.company.heartbeatsignal.util.JsonUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * @className JsonRedisSerializer
 * @auther Liquid
 * @description
 * @date 2018/12/20
 */
public class JsonRedisSerializer<T> implements RedisSerializer<T> {
    private final Charset charset = Charset.forName("UTF-8");

    private Class<T> clazz;

    public JsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }

        return JSONObject.toJSONString(t, SerializerFeature.WriteClassName).getBytes(charset);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, charset);
        T result = JsonUtils.toJavaObject(str, clazz);
        return result;

    }
}
