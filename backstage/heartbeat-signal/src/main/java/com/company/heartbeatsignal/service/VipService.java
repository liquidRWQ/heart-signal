package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.VipDTO;
import com.company.heartbeatsignal.service.infc.Cruder;

/**
 * @author Liquid
 * @类名： VipService
 * @描述：
 * @date 2019/5/8
 */
public interface VipService extends Cruder<VipDTO>{

    VipDTO selectByUserId(VipDTO vipDTO);
}
