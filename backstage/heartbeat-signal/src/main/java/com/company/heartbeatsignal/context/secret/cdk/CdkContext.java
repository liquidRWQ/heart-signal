package com.company.heartbeatsignal.context.secret.cdk;

import com.company.heartbeatsignal.service.infc.CdkConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Liquid
 * @类名： CdkContext
 * @描述：
 * @date 2019/5/24
 */

@Component("cdkContext")
public class CdkContext<T> {

    @Autowired
    private final Map<String, CdkConvert> strategyMap = new ConcurrentHashMap<>();

    public void convertCdk(String beanName,T t){
        this.strategyMap.get(beanName).convert(t);
    }
}
