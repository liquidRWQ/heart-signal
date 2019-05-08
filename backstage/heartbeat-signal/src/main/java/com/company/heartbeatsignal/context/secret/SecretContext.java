package com.company.heartbeatsignal.context.secret;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Liquid
 * @类名： SecretContext
 * @描述：
 * @date 2019/4/14
 */
@Component("secretContext")
public class SecretContext {

    @Autowired
    private final Map<String, IrreversibleEncryptible> strategyMap = new ConcurrentHashMap<>();

    public String encrypt(String data, String beanName) {
        return this.strategyMap.get(beanName).encrypt(data);
    }
}
