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
@Table(name = "user_base_info")
public class UserBaseInfo implements Serializable,TimeSet {
    private static final long serialVersionUID = -4791947128472726037L;
    /**
     * 用户信息id
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
     * 用户性别
     */
    private Short gender;



    /**
     * 用户昵称
     */
    private String realName;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户身高
     */
    private Double height;

    /**
     * 毕业或就读大学
     */
    private String collage;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 最高学历
     */
    @Column(name = "highest_education")
    private String highestEducation;

    /**
     * 用户生日
     */
    private Date birthday;

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
     * 用户对自己的描述
     */
    private String about;

    /**
     * 用户的兴趣爱好
     */
    private String hobby;

    /**
     * 用户的感情观
     */
    @Column(name = "emotional_view")
    private String emotionalView;

    /**
     * 用户的好友印象
     */
    @Column(name = "friend_impression")
    private String friendImpression;

    /**
     * 用户心仪对象的描述
     */
    @Column(name = "love_her")
    private String loveHer;

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