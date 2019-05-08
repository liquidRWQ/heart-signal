package com.company.heartbeatsignal.context.secret.aes;

import com.company.heartbeatsignal.exception.CheckedException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author Liquid
 * @类名： AesKeyGeneratorUtil
 * @描述： 生产AES秘钥的工具类
 * @date 2018/12/28
 */
public class AesKeyGeneratorUtils {

    /**
     * 获取秘钥的加密方式
     */
    private static final String KEY_ALGORITHM = "AES";

    /**
     * 秘钥的位数
     */
    private static final int NUMBER_OF_DIGITS = 128;

    /**
     *
     */
    /**
     * @param ；
     * @return byte[] 秘钥的字节数组
     * @throws CheckedException 检查异常
     * @author Liquid
     * @描述： 随机生成128位秘钥
     * @date 2018/12/26
     */
    public static byte[] getAesKey() throws CheckedException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
            keyGenerator.init(NUMBER_OF_DIGITS);
            //要生成多少位，只需要修改这里即可128, 192或256
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            throw new CheckedException("生成随机AES秘钥异常:" + e.toString());
        }

    }

    /**
     * @param seed 种子（用于获取指定的秘钥）
     * @return byte[] 生产的秘钥的字节数组
     * @throws CheckedException 检查异常
     * @author Liquid
     * @描述： 使用种子生成秘钥
     * @date 2018/12/26
     */
    public static byte[] getKeyBySeed(String seed) throws CheckedException {

        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以生成的秘钥就一样。
            keyGenerator.init(128, new SecureRandom(seed.getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            throw new CheckedException("生成指定AES秘钥异常");

        }

    }

}
