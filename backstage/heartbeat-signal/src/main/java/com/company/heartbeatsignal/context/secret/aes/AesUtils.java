package com.company.heartbeatsignal.context.secret.aes;

import com.company.heartbeatsignal.exception.CheckedException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.UUID;

/**
 * @author Liquid
 * @className AesUtil
 * @description
 * @date 2018/12/26
 */
public class AesUtils {
    /**
     * 默认加密类型
     */
    private static final String DEFAULT_AES_TYPE = "AES/CBC/PKCS5Padding";
    /**
     * 默认加密类型
     */
    private static final String WE_CHAT_AES_TYPE = "AES/CBC/PKCS7Padding";
    /**
     * 默认加密类型
     */
    private static final String NO_AES_TYPE = "AES/CBC/NoPadding";
    /**
     * 加密方式
     */
    private static final String ENCRYPTION = "AES";
    /**
     * 解码类型
     */
    private static final String ENCODING_FORMAT = "UTF-8";

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * @param
     * @return 解密后的数据
     * @auther Liquid
     * @description 对微信的AES解密，PKCS7Padding
     * @date 2018/12/26
     */
    public static String decrypt(String data, String key, String iv, String decryptType) throws CheckedException {

        byte[] dataByte = Base64Utils.base64StringDecodeToBytes(data);
        byte[] keyByte = Base64Utils.base64StringDecodeToBytes(key);
        byte[] ivByte = Base64Utils.base64StringDecodeToBytes(iv);
        return defaultDecrypt(dataByte, keyByte, ivByte, decryptType);

    }

    /**
     * @param
     * @return 解密后的数据
     * @auther Liquid
     * @description 对微信的AES解密，PKCS7Padding
     * @date 2018/12/26
     */
    public static String decrypt(byte[] dataByte, byte[] keyByte, byte[] ivByte, String decryptType) throws CheckedException {
        return defaultDecrypt(dataByte, keyByte, ivByte, decryptType);

    }

    /**
     * @param
     * @author Liquid
     * @description 字符串AES加密
     * @date 2018/12/26
     */
    public static byte[] encrypt(String data, String key, String iv, String decryptType) throws CheckedException {
        byte[] dataByte = Base64Utils.base64StringDecodeToBytes(data);
        byte[] keyByte = Base64Utils.base64StringDecodeToBytes(key);
        byte[] ivByte = Base64Utils.base64StringDecodeToBytes(iv);
        return defultEnctypt(dataByte, keyByte, ivByte, decryptType);
    }

    /**
     * @param dataBytes,keyBytes,ivBytes
     * @return 加密后的数据
     * @author Liquid
     * @description 字节流AES加密
     * @date 2018/12/26
     */
    public static byte[] encrypt(byte[] dataBytes, byte[] keyBytes, byte[] ivBytes, String decryptType) throws CheckedException {

        return defultEnctypt(dataBytes, keyBytes, ivBytes, decryptType);
    }

    /**
     * @param
     * @return Base64秘钥字符串
     * @author Liquid
     * @description 获取随机Aes秘钥Base64字符串
     * @date 2018/12/26
     */
    public static String getBase64AesKey() throws CheckedException {
        byte[] aesKey = AesKeyGeneratorUtils.getAesKey();
        return Base64Utils.bytesEncodeToBase64String(aesKey);
    }

    /**
     * @param seed
     * @return Base64秘钥字符串
     * @auther Liquid
     * @description 获取唯一Aes秘钥Base64字符串
     * @date 2018/12/23
     */
    public static String getBase64AesKeyBySeed(String seed) throws CheckedException {

        byte[] aesKey = AesKeyGeneratorUtils.getKeyBySeed(seed);
        return Base64Utils.bytesEncodeToBase64String(aesKey);
    }

    /**
     * @param
     * @return Base64iv字符串
     * @auther Liquid
     * @description 获取随机iv
     * @date 2018/12/23
     */
    public static String getBase64Iv() {

        String uuid = UUID.randomUUID().toString().substring(0, 16).replace("-", "0");
        return Base64Utils.stringEncodeToBase64String(uuid);
    }

    private static String defaultDecrypt(byte[] dataByte, byte[] keyByte, byte[] ivByte, String decryptType) throws CheckedException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyByte, ENCRYPTION);
            Cipher cipher = Cipher.getInstance(decryptType);
            AlgorithmParameters parameters = AlgorithmParameters.getInstance(ENCRYPTION);
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, parameters);
            byte[] resultByte = cipher.doFinal(dataByte);
            return new String(resultByte, ENCODING_FORMAT);
        } catch (Exception e) {
            throw new CheckedException("AES解密异常:" + e.toString());
        }
    }

    private static byte[] defultEnctypt(byte[] dataByte, byte[] keyByte, byte[] ivByte, String decryptType) throws CheckedException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyByte, ENCRYPTION);
            Cipher cipher = Cipher.getInstance(decryptType);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivByte);
            AlgorithmParameters parameters = AlgorithmParameters.getInstance(ENCRYPTION);
            parameters.init(ivParameterSpec);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, parameters);
            return cipher.doFinal(dataByte);
        } catch (Exception e) {
            throw new CheckedException("AES加密异常:" + e.toString());
        }
    }
}
