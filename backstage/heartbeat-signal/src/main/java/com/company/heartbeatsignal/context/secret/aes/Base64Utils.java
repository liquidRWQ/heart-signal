package com.company.heartbeatsignal.context.secret.aes;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Liquid
 * @类名： Base64Util
 * @描述： Base64编码工具类
 * @date 2018/12/28
 */
public class Base64Utils {
    /**
     * @param data 要编码的字符串
     * @return Base64字符串
     * @描述： 普通字符串编码成Base64字符串
     * @author Liquid
     * @date 2018/12/26
     */
    public static String stringEncodeToBase64String(String data) {
        return Base64.encodeBase64String(data.getBytes());
    }

    /**
     * @param dataBytes 要编码的字节数组
     * @return Base64字符串
     * @throws null
     * @描述： 字节数组编码成Base64字符串
     * @author Liquid
     * @date 2018/12/26
     */
    public static String bytesEncodeToBase64String(byte[] dataBytes) {
        return Base64.encodeBase64String(dataBytes);
    }

    /**
     * @param data 要编码的字符串
     * @return Base64字节数组
     * @throws null
     * @描述： 普通字符串编码成Base64字节数组
     * @author Liquid
     * @date 2018/12/26
     */
    public static byte[] stringEncodeToBase64Bytes(String data) {
        return Base64.encodeBase64(data.getBytes());
    }

    /**
     * @param dataBytes 要编码的字节数组
     * @return Base64字节数组
     * @throws null
     * @描述： 普通字节数组编码成Base64字节数组
     * @author Liquid
     * @date 2018/12/26
     */
    public static byte[] bytesEncodeToBase64Bytes(byte[] dataBytes) {

        return Base64.encodeBase64(dataBytes);
    }

    /**
     * @param base64dataBytes 要解码的base64字节数组
     * @return 解码后的普通字节数组
     * @throws null
     * @描述： Base64字节数组解码成普通字节数组
     * @author Liquid
     * @date 2018/12/26
     */
    public static byte[] base64BytesDecodeToBytes(byte[] base64dataBytes) {
        return Base64.decodeBase64(base64dataBytes);
    }

    /**
     * @param base64Data 要解码的base64字符串
     * @return 解码后的普通字节数组
     * @throws null
     * @描述： Base64字符串解码成普通字节数组
     * @author Liquid
     * @date 2018/12/26
     */
    public static byte[] base64StringDecodeToBytes(String base64Data) {
        return Base64.decodeBase64(base64Data);
    }

}