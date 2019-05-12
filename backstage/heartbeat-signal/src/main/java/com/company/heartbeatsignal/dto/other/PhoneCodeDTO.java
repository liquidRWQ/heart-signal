package com.company.heartbeatsignal.dto.other;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： PhoneCodeDTO
 * @描述：
 * @date 2019/5/11
 */
@Data
public class PhoneCodeDTO implements Serializable{

    private static final long serialVersionUID = 1239743502880038493L;
    String phoneNumber;

    Long timeStamp;

    String code;
}
