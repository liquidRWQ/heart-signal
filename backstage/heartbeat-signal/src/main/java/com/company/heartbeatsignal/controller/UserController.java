package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.UserDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liquid
 * @类名： UserController
 * @描述：
 * @date 2019/4/18
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultBean login(@Validated UserDTO userDTO, BindingResult bindingResult) throws Exception {
        String userId = userService.login(userDTO);
        return new ResultBean<String>(userId);
    }
}
