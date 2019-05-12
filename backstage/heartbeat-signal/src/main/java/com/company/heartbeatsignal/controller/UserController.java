package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.UserDTO;
import com.company.heartbeatsignal.dto.other.PhoneCodeDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.UserService;
import com.company.heartbeatsignal.util.PhoneCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        int userId = userService.login(userDTO);
        return new ResultBean<Integer>(userId);
    }

    @GetMapping("/setCode")
    public ResultBean setCode(PhoneCodeDTO phoneCodeDTO) throws Exception {
        PhoneCodeUtils.sendCode(phoneCodeDTO);
        return new ResultBean<PhoneCodeDTO>(phoneCodeDTO);
    }

    @PostMapping("/setPhoneNumber")
    public ResultBean setPhoneNumber(UserDTO userDTO) throws Exception {
        userService.setPhoneNumber(userDTO);
        return new ResultBean<>();
    }

    @PostMapping("/idCardVerified")
    public ResultBean idCardVerified(UserDTO userDTO) throws Exception {

        return new ResultBean<>();
    }
}
