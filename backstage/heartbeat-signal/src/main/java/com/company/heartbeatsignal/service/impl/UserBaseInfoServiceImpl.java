package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.UserBaseInfoMapper;
import com.company.heartbeatsignal.dto.entity.UserBaseInfoDTO;
import com.company.heartbeatsignal.entity.UserBaseInfo;
import com.company.heartbeatsignal.service.UserBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public void insert(UserBaseInfoDTO userBaseInfoDTO) {
        UserBaseInfo userBaseInfo = userBaseInfoDTO.convertToUserBaseInfo();
        userBaseInfo.setAllTime();
        userBaseInfoMapper.insert(userBaseInfo);

    }

    @Override
    public List<UserBaseInfoDTO> selectAll() {
        List<UserBaseInfo> userBaseInfos = userBaseInfoMapper.selectAll();
        ArrayList<UserBaseInfoDTO> userBaseInfoDTOS = new ArrayList<>();
        for (UserBaseInfo userBaseInfo : userBaseInfos) {
            userBaseInfoDTOS.add(new UserBaseInfoDTO().convertToUserBaseInfoDTO(userBaseInfo));
        }
        return userBaseInfoDTOS;
    }

    @Override
    public void updateByPrimary(UserBaseInfoDTO userBaseInfoDTO) {
        UserBaseInfo userBaseInfo = userBaseInfoDTO.convertToUserBaseInfo();
        userBaseInfo.refreshLastUpdateTime();
        userBaseInfoMapper.updateByPrimaryKeySelective(userBaseInfo);
    }

    @Override
    public void deleteByPrimary(UserBaseInfoDTO userBaseInfoDTO) {
        userBaseInfoMapper.deleteByPrimaryKey(userBaseInfoDTO.getId());
    }

    @Override
    public UserBaseInfoDTO selectByPrimary(UserBaseInfoDTO userBaseInfoDTO) {
        return userBaseInfoDTO.convertToUserBaseInfoDTO(userBaseInfoMapper.selectOne(userBaseInfoDTO.convertToUserBaseInfo()));
    }

    @Override
    public UserBaseInfoDTO selectByUserId(UserBaseInfoDTO userBaseInfoDTO) {
        UserBaseInfo userBaseInfo = userBaseInfoMapper.selectOne(userBaseInfoDTO.convertToUserBaseInfo());
        if (userBaseInfo == null) {
            return null;
        }
        return new UserBaseInfoDTO().convertToUserBaseInfoDTO(userBaseInfo);
    }
}
