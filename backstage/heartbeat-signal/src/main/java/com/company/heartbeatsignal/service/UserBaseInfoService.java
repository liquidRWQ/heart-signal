package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.UserBaseInfoDTO;

/**
 * @author Liquid
 * @类名： UserBaseInfoService
 * @描述：
 * @date 2019/5/8
 */
public interface UserBaseInfoService {

    void  addUserBaseInfo(UserBaseInfoDTO userBaseInfoDTO);

    void  updateUserBaseInfo(UserBaseInfoDTO userBaseInfoDTO);

    UserBaseInfoDTO getOneUserBaseInfo(UserBaseInfoDTO userBaseInfoDTO);
}
