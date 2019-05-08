package com.company.heartbeatsignal.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/5/8
 */

@Data
@Table(name = "cdk")
public class Cdk implements Serializable {
    private static final long serialVersionUID = -4417301447381358639L;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 兑换码
     */
    private String cdk;

    /**
     * 兑换奖励
     */
    private String reward;

    /**
     * 兑换码过期时间
     */
    @Column(name = "stop_time")
    private Date stopTime;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 最后修改时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

}