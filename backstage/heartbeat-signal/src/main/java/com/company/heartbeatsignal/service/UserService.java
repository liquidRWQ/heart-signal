package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.UserDTO;
import com.company.heartbeatsignal.exception.CheckedException;

/**
 * @author Liquid
 * @类名： UserService
 * @描述：
 * @date 2019/4/18
 */
public interface UserService {
    int login(UserDTO userDTO) throws CheckedException;

    void setPhoneNumber(UserDTO userDTO);
}
