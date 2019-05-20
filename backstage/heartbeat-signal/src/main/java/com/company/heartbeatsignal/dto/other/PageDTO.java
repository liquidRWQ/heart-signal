package com.company.heartbeatsignal.dto.other;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： PageDTO
 * @描述：
 * @date 2019/5/20
 */
@Data
public class PageDTO implements Serializable {
    private static final long serialVersionUID = -8054461084508509074L;

    /**
    *   第几页
    */
    Integer pageNumber;

    /**
    *   每页记录数
    */
    Integer pageSize;
}
