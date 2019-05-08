package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.entity.UserDTO; /**
 * @author Liquid
 * @类名： UserService
 * @描述：
 * @date 2019/4/18
 */
public interface UserService {
    String login(UserDTO userDTO);
}
