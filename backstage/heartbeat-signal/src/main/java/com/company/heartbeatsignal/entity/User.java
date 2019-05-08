package com.company.heartbeatsignal.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @className User
 * @auther Liquid
 * @description
 * @date 2018/11/21
 */
@Data
@Table(name = "repair_user")
public class User implements Serializable {
    private static final long serialVersionUID = -1683183409242638787L;
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String userId;

    /**
     * 微信userOpenid
     */
    @Column(name = "user_openid")
    private String userOpenid;

    /**
     * 用户会话钥匙
     */
    @Column(name = "user_session_key")
    private String userSessionKey;

    /**
     * 用户头像
     */
    @Column(name = "user_avatar_url")
    private String userAvatarUrl;

    /**
     * 微信呢称
     */
    @Column(name = "user_nickname")
    private String userNickname;

    /**
     * 用户所在城市
     */
    @Column(name = "user_city")
    private String userCity;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;


}