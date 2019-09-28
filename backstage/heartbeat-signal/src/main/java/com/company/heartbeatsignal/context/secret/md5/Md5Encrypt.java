package com.company.heartbeatsignal.context.secret.md5;

import com.company.heartbeatsignal.context.secret.IrreversibleEncryptible;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * @author Liquid
 * @类名： md5Encrypt
 * @描述：
 * @date 2019/4/14
 */
@Component("md5")
public class Md5Encrypt implements IrreversibleEncryptible {

    /**
     * 登录密码加密的次数
     */
    public static final Integer LOGIN_HASH_ITERATIONS = 1024;
    /**
     * 数据签名的加密次数
     */
    public static final Integer SIGNATURE_HASH_ITERATIONS = 2;

    private static HashFunction hashFunction = Hashing.md5();

    private static Charset charset = Charset.forName("UTF-8");


    @Override
    public String encrypt(String data) {
        return hashFunction.newHasher().putString(data, charset).hash().toString();
    }
}
