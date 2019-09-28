package com.company.heartbeatsignal.context.pay.ali;

import com.company.heartbeatsignal.context.pay.Payer;
import com.company.heartbeatsignal.dto.other.PayDTO;
import org.springframework.stereotype.Component;

/**
 * @className ALiPay
 * @auther Liquid
 * @description
 * @date 2019/5/25/025
 */
@Component("aliPay")
public class AliPay implements Payer {
    @Override
    public void pay(PayDTO payDTO) {

    }
}
