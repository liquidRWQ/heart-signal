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
@Table(name = "bad_report")
public class BadReport implements Serializable,TimeSet{
    private static final long serialVersionUID = 2111760490255225847L;
    /**
     * 举报id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 举报原因
     */
    @Column(name = "report_reason")
    private String reportReason;

    /**
     * 举报用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 举报截图
     */
    @Column(name = "img_path")
    private String imgPath;

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
     * 举报信息
     */
    @Column(name = "report_info")
    private String reportInfo;

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