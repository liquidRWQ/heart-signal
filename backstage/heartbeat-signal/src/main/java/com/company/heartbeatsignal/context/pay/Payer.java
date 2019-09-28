package com.company.heartbeatsignal.context.pay;

import com.company.heartbeatsignal.dto.other.PayDTO;
import com.company.heartbeatsignal.exception.CheckedException;

/**
 * @className Payer
 * @auther Liquid
 * @description
 * @date 2019/5/25/025
 */
public interface Payer {

    void pay(PayDTO payDTO) throws CheckedException;
}
