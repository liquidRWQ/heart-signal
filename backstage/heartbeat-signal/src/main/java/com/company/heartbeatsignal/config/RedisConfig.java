package com.company.heartbeatsignal.config;

import com.company.heartbeatsignal.dao.nosql.redis.serializer.JsonRedisSerializer;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @className RedisConfig
 * @auther Liquid
 * @description
 * @date 2018/12/20
 */
@Configuration
public class RedisConfig {


    /**
     * @param redisConnectionFactory
     * @return RedisTemplate
     * @author Liquid
     * @description ioc配置redis模板工具
     * @date 2018/12/26
     */

    @Bean("redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        JsonRedisSerializer<Object> fastJsonRedisSerializer = new JsonRedisSerializer<>(Object.class);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // 设置值（value）的序列化采用FastJsonRedisSerializer。
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        // 设置键（key）的序列化采用StringRedisSerializer。
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * @param redisTemplate
     * @return CacheManager
     * @author Liquid
     * @description ioc配置spring缓存管理器
     * @date 2018/12/26
     */
    @Bean()
    public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {

        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;

    }

}
