package com.company.heartbeatsignal.dto.other;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： PayDTO
 * @描述：
 * @date 2019/5/25
 */
@Data
public class PayDTO implements Serializable {
    private static final long serialVersionUID = 8152866091775927331L;

    String userOpenid;

    String productName;

    String totalFee;

    String nonceString;

    String spbillCreateIp;

    String sign;

    String prepayId;

    Long timeStamp;

    String outTradeNo;

    String ip;

    String paySign;
}
