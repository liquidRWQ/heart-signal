package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.UserDTO;
import com.company.heartbeatsignal.dto.other.PageDTO;
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

@RestController
public class UserController  {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResultBean login(@Validated UserDTO userDTO, BindingResult bindingResult) throws Exception {
        return new ResultBean<>(userService.login(userDTO));
    }

    @GetMapping("/sendCode")
    public ResultBean sendCode(PhoneCodeDTO phoneCodeDTO) throws Exception {
        PhoneCodeUtils.sendCode(phoneCodeDTO);
        return new ResultBean<PhoneCodeDTO>(phoneCodeDTO);
    }

    @PostMapping("/addPhoneNumber")
    public ResultBean setPhoneNumber(UserDTO userDTO,PhoneCodeDTO phoneCodeDTO) throws Exception {
        userService.setPhoneNumber(userDTO,phoneCodeDTO);
        return new ResultBean<>();
    }

    @PostMapping("/idCardVerified")
    public ResultBean idCardVerified(UserDTO userDTO) throws Exception {
        return new ResultBean<>();
    }

    @GetMapping("/getUsersByUserIdList")
    public ResultBean getUsersByUserIdList(UserDTO userDTO) throws Exception {
        return new ResultBean<>(userService.selectByUserIdList(userDTO));
    }

    @GetMapping("/getUser")
    public ResultBean getOne(UserDTO userDTO) {
        return new ResultBean<>(userService.selectByPrimary(userDTO));
    }

    @GetMapping("/getUsers")
    public ResultBean getAll() {
        return new ResultBean<>(userService.selectAll());
    }

    @PostMapping("/addUser")
    public ResultBean addOne(UserDTO userDTO) throws Exception {
        userService.insert(userDTO);
        return new ResultBean<>();
    }

    @PutMapping("/updateUser")
    public ResultBean updateOne(UserDTO userDTO) {
        userService.updateByPrimary(userDTO);
        return new ResultBean<>();
    }

    public ResultBean deleteOne(UserDTO userDTO) {
        userService.deleteByPrimary(userDTO);
        return new ResultBean<>();
    }

    @GetMapping("/getUsersInIndex")
    public ResultBean getUsersInIndex(PageDTO pageDTO) {
        return new ResultBean<>(userService.selectInIndex(pageDTO));
    }

}
