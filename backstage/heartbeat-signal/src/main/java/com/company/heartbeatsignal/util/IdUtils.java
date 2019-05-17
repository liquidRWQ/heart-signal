package com.company.heartbeatsignal.util;

import java.util.UUID;

/**
* @类名： IdUtil
*
* @author Liquid
*
* @描述： 获取特定Id的工具类
*
* @date   2018/12/28
*/
public class IdUtils {

    /**
     * @param ;
     * @return java.lang.String 随机字符的字符串
     * @描述： 获取随机字符id
     * @author Liquid
     * @date 2018/12/26
     */
    public static String getRandomStringId() {
        return UUID.randomUUID().toString().replace("-", "")+TimeUtils.getCurrentTimeMills();
    }

    /**
     * @param ;
     * @return java.lang.String 随机字符的字符串
     * @描述： 获取uuid
     * @author Liquid
     * @date 2018/12/26
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

}
