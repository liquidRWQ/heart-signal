package com.company.heartbeatsignal.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Liquid
 * @类名： JsonUtil
 * @描述： json转换的工具类
 * @date 2019/4/13
 */
public class JsonUtils {

    private JsonUtils(){

    }

    /**
     * @param json json对象
     * @return java.lang.String Json字符串
     * @描述： json对象转换成Json字符串
     * @author Liquid
     * @date 2018/12/26
     */
    public static String toJSONString(Object json) {
        return JSONObject.toJSONString(json);
    }

    /**
     * @param json  json字符串
     * @param clazz 对象的字节码文件名
     * @return T 指定泛类型
     * @描述： 根据泛型，将json字符串转换并封装成java对象
     * @author Liquid
     * @date 2018/12/26
     */
    public static <T> T toJavaObject(String json, Class<T> clazz) {

        return JSONObject.parseObject(json, clazz);
    }

    /**
     * @param json json字符串
     * @return com.alibaba.fastjson.JSONObject json的封装对象
     * @描述： 将json字符串转成javaObject
     * @author Liquid
     * @date 2018/12/26
     */
    public static JSONObject toJSONObject(String json) {

        return JSONObject.parseObject(json);
    }

}
