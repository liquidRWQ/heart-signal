package com.company.heartbeatsignal.context.ramdomid;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Liquid
 * @类名： RomdomIdContext
 * @描述：
 * @date 2019/4/14
 */
@Component("randomIdContext")
public class RandomIdContext {

    private static final Map<String,StringRandomizer> stringRandomizerMap=new ConcurrentHashMap<>(16);


    public String getRandomId(String beanName) {
        return stringRandomizerMap.get(beanName).getRandom();
    }
}
