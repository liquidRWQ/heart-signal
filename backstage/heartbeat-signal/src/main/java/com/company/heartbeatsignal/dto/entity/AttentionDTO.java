package com.company.heartbeatsignal.dto.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Liquid
 * @类名： AttentionDTO
 * @描述：
 * @date 2019/5/8
 */
@Data
public class AttentionDTO implements Serializable {
    private static final long serialVersionUID = 9132201952870298347L;
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 关联用户id
     */
    private Integer userId;

    /**
     * 关注者用户id
     */
    private Integer attentionUserId;

}
