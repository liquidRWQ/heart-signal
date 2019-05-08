package com.company.heartbeatsignal.context.template.factory;

import com.company.heartbeatsignal.context.template.SendTemplator;
import com.company.heartbeatsignal.context.template.SendTemplatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Liquid
 * @类名： HeartBeatSendTemplatorFactory
 * @描述：
 * @date 2019/4/17
 */
@Component("heartBeatSendTemplatorFactory")
public class HeartBeatSendTemplatorFactory implements SendTemplatorFactory {

    @Autowired
    private final Map<String, SendTemplator> sendTemplatorMap = new ConcurrentHashMap<>(16);

    @Override
    public SendTemplator createSendTemplator(String beanName) {
        return this.sendTemplatorMap.get(beanName);
    }
}
