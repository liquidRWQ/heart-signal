package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.UserBaseInfoMapper;
import com.company.heartbeatsignal.dto.entity.UserBaseInfoDTO;
import com.company.heartbeatsignal.entity.UserBaseInfo;
import com.company.heartbeatsignal.service.UserBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Liquid
 * @类名： UserBaseInfoServiceImpl
 * @描述：
 * @date 2019/5/8
 */
@Service("userBaseInfoServiceImpl")
public class UserBaseInfoServiceImpl implements UserBaseInfoService {

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;

    @Override
    public void addUserBaseInfo(UserBaseInfoDTO userBaseInfoDTO) {
        UserBaseInfo userBaseInfo = userBaseInfoDTO.convertToUserBaseInfo();
        userBaseInfo.setAllTime();
        userBaseInfoMapper.insert(userBaseInfo);

    }

    @Override
    public void updateUserBaseInfo(UserBaseInfoDTO userBaseInfoDTO) {
        UserBaseInfo userBaseInfo = userBaseInfoDTO.convertToUserBaseInfo();
        userBaseInfo.refreshLastUpdateTime();
        userBaseInfoMapper.updateByPrimaryKeySelective(userBaseInfo);
    }

    @Override
    public UserBaseInfoDTO getOneUserBaseInfo(UserBaseInfoDTO userBaseInfoDTO) {
        return userBaseInfoDTO.convertToUserBaseInfoDTO(userBaseInfoMapper.selectOne(userBaseInfoDTO.convertToUserBaseInfo()));
    }
}
