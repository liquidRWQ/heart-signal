package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.UserDTO;
import com.company.heartbeatsignal.dto.other.PageDTO;
import com.company.heartbeatsignal.dto.other.PhoneCodeDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.service.infc.Cruder;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Liquid
 * @类名： UserService
 * @描述：
 * @date 2019/4/18
 */
public interface UserService extends Cruder<UserDTO> {
    int login(UserDTO userDTO) throws CheckedException;

    void setPhoneNumber(UserDTO userDTO, PhoneCodeDTO phoneCodeDTO);

    List<UserDTO> selectByUserIdList(UserDTO userDTO);

    PageInfo selectInIndex(PageDTO pageDTO);
}
