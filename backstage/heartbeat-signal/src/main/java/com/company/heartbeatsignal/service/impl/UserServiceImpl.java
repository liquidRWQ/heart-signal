package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.UserMapper;
import com.company.heartbeatsignal.dto.entity.UserDTO;
import com.company.heartbeatsignal.dto.other.PageDTO;
import com.company.heartbeatsignal.dto.other.PhoneCodeDTO;
import com.company.heartbeatsignal.entity.User;
import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.exception.UserException;
import com.company.heartbeatsignal.service.UserService;
import com.company.heartbeatsignal.util.CodeUtils;
import com.company.heartbeatsignal.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public void setPhoneNumber(UserDTO userDTO, PhoneCodeDTO phoneCodeDTO) {
        if (TimeUtils.getCurrentTimeMills() > phoneCodeDTO.getTimeStamp() + (long) (300 * 1000)) {
            throw new UserException("验证码过期");
        } else {
            userMapper.updateByPrimaryKeySelective(userDTO.convertToUser());
        }
    }

    @Override
    public List<UserDTO> selectByUserIdList(UserDTO userDTO) {
        List<User> users = userMapper.setByPrimaryKeyList(userDTO.getIds());
        ArrayList<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(new UserDTO().convertToUserDTO(user));
        }
        return userDTOS;
    }

    @Override
    public PageInfo selectInIndex(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPageNumber(), pageDTO.getPageSize());
        List<UserDTO> users = userMapper.selectInIndex();
        return new PageInfo<UserDTO>(users);
    }

    @Override
    public void insert(UserDTO userDTO) {
        User user = userDTO.convertToUser();
        user.setAllTime();
        userMapper.insert(user);
    }

    @Override
    public List<UserDTO> selectAll() {
        List<User> users = userMapper.selectAll();
        ArrayList<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(new UserDTO().convertToUserDTO(user));
        }
        return userDTOS;
    }

    @Override
    public UserDTO selectByPrimary(UserDTO userDTO) {
        return new UserDTO().convertToUserDTO(userMapper.selectByPrimaryKey(userDTO.getId()));
    }

    @Override
    public void updateByPrimary(UserDTO userDTO) {
        User user = userDTO.convertToUser();
        user.refreshLastUpdateTime();
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteByPrimary(UserDTO userDTO) {
        userMapper.deleteByPrimaryKey(userDTO.getId());
    }
}
