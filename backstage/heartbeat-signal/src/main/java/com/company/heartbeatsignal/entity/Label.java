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
@Table(name = "label")
public class Label implements Serializable{
    private static final long serialVersionUID = 992708015309198290L;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 关联用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 标签分类
     */
    @Column(name = "label_class")
    private String labelClass;

    /**
     * 标签名
     */
    @Column(name = "label_name")
    private String labelName;

    /**
     * 标签认可状态
     */
    private String status;

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