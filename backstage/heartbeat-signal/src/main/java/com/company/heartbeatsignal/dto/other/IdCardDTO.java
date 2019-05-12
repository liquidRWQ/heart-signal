package com.company.heartbeatsignal.dto.other;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： IdCardDTO
 * @描述：
 * @date 2019/5/11
 */
@Data
public class IdCardDTO implements Serializable {
    private static final long serialVersionUID = -7702159733211678567L;

    String idCard;

    String realName;
}
