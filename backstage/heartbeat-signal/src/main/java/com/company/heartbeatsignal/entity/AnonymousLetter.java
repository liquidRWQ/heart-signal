package com.company.heartbeatsignal.entity;

import com.company.heartbeatsignal.util.TimeUtils;
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
@Table(name = "anonymous_letter")
public class AnonymousLetter implements Serializable, TimeSet {
    private static final long serialVersionUID = 8378273110029329571L;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 匿名信发送者id
     */
    @Column(name = "sender_id")
    private Integer senderId;

    /**
     * 匿名信接受者id
     */
    @Column(name = "receiver_id")
    private Integer receiverId;

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

    /**
     * 匿名信内容
     */
    private String info;

    @Override
    public void setAllTime() {
        Date currentTime = TimeUtils.getCurrentTime();
        this.setCreatedTime(currentTime);
        this.setLastUpdateTime(currentTime);
    }

    @Override
    public void refreshLastUpdateTime() {
        this.setLastUpdateTime(TimeUtils.getCurrentTime());
    }
}