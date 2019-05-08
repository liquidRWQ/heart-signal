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
@Table(name = "visitor")
public class Visitor implements Serializable {
    private static final long serialVersionUID = -7700815285592321849L;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 关联被访问用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 访客用户id
     */
    @Column(name = "visitor_user_id")
    private Integer visitorUserId;

    /**
     * 来访时间
     */
    @Column(name = "visit_time")
    private Date visitTime;

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