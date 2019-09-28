package com.company.heartbeatsignal.entity;

import com.company.heartbeatsignal.util.IdUtils;
import com.company.heartbeatsignal.util.TimeUtils;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/5/17
 */
@Data
@Table(name = "heartbeat_vip_order")
public class VipOrder implements Serializable, TimeSet, IdSet {
    private static final long serialVersionUID = -2717252352607668344L;
    /**
     * id
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 关联用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 订单金额
     */
    @Column(name = "order_price")
    private Double orderPrice;

    /**
     * 订单完成时间
     */
    @Column(name = "order_time")
    private Date orderTime;

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

    @Override
    public void setRandomId() {
        this.id= "vipOrder"+IdUtils.getRandomStringId();
    }

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