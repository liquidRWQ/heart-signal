package com.company.heartbeatsignal.dto.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/5/8
 */
@Data
public class AnonymousLetterDTO implements Serializable {

    private static final long serialVersionUID = -7765247949839045385L;
    /**
     * id
     */

    private Integer id;

    /**
     * 匿名信发送者id
     */
    private Integer senderId;

    /**
     * 匿名信接受者id
     */
    private Integer receiverId;

    /**
     * 匿名信内容
     */
    private String info;

}