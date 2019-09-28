package com.company.heartbeatsignal.context.secret.sha1;

import com.company.heartbeatsignal.context.secret.IrreversibleEncryptible;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * @author Liquid
 * @类名： Sha1Encrypt
 * @描述：
 * @date 2019/4/14
 */
@Component("sha1")
public class Sha1Encrypt implements IrreversibleEncryptible {

    private static HashFunction hashFunction = Hashing.sha1();

    private static Charset charset = Charset.forName("UTF-8");

    @Override
    public String encrypt(String data) {
        return hashFunction.newHasher().putString(data, charset).hash().toString();
    }
}
