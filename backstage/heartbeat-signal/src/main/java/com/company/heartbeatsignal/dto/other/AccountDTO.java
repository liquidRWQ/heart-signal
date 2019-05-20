package com.company.heartbeatsignal.dto.other;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： AccountDTO
 * @描述：
 * @date 2019/5/20
 */
@Data
public class AccountDTO implements Serializable{
    private static final long serialVersionUID = -5192714339170821564L;

    Integer userId;

    Integer visitorAccount;

    Integer attentionAccount;

    Integer attentionedAccount;
}
