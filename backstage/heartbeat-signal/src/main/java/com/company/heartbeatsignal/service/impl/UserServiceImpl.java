package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.UserMapper;
import com.company.heartbeatsignal.dto.entity.UserDTO;
import com.company.heartbeatsignal.entity.User;
import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.service.UserService;
import com.company.heartbeatsignal.util.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Liquid
 * @类名： UserServiceImpl
 * @描述：
 * @date 2019/4/18
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int login(UserDTO userDTO) throws CheckedException {
        CodeUtils.getUserOpenIdByWeChatLoginDTO(userDTO);
        Integer userId = userMapper.selectUserId(userDTO.getUserOpenid());
        if (userId == null) {
            User user = userDTO.convertToUser();
            user.setAllTime();
            userMapper.insert(user);
            userId = user.getId();
        }

        return userId;

    }

    @Override
    public void setPhoneNumber(UserDTO userDTO) {
        userMapper.updateByPrimaryKeySelective(userDTO.convertToUser());
    }

}
