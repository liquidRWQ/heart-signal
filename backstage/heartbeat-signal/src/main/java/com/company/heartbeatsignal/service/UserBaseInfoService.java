package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.UserBaseInfoDTO;
import com.company.heartbeatsignal.service.infc.Cruder;

/**
 * @author Liquid
 * @类名： UserBaseInfoService
 * @描述：
 * @date 2019/5/8
 */
public interface UserBaseInfoService extends Cruder<UserBaseInfoDTO>{

    UserBaseInfoDTO selectByUserId(UserBaseInfoDTO userBaseInfoDTO);
}
