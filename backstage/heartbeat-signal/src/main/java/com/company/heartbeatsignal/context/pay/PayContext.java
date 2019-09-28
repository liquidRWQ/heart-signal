package com.company.heartbeatsignal.context.pay;

import com.company.heartbeatsignal.dto.other.PayDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @className PayContext
 * @auther Liquid
 * @description
 * @date 2019/5/25/025
 */
@Component
public class PayContext {

    @Autowired
    private final Map<String, Payer> strategyMap = new ConcurrentHashMap<>();

    public void pay(PayDTO payDTO, String beanName) throws CheckedException {
        this.strategyMap.get(beanName).pay(payDTO);
    }

}
