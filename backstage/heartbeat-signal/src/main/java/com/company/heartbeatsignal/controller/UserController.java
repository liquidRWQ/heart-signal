package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.UserDTO;
import com.company.heartbeatsignal.dto.other.PageDTO;
import com.company.heartbeatsignal.dto.other.PhoneCodeDTO;
import com.company.heartbeatsignal.vo.ResultVO;
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
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultVO login(@Validated UserDTO userDTO, BindingResult bindingResult) throws Exception {

        return new ResultVO<>(userService.login(userDTO));
    }

    @GetMapping("/sendCode")
    public ResultVO sendCode(PhoneCodeDTO phoneCodeDTO) throws Exception {
        PhoneCodeUtils.sendCode(phoneCodeDTO);
        return new ResultVO<PhoneCodeDTO>(phoneCodeDTO);
    }

    @PostMapping("/addPhoneNumber")
    public ResultVO setPhoneNumber(UserDTO userDTO, PhoneCodeDTO phoneCodeDTO) throws Exception {
        userService.setPhoneNumber(userDTO, phoneCodeDTO);
        return new ResultVO<>();
    }

    @PostMapping("/phoneVerified")
    public ResultVO idCardVerified(UserDTO userDTO, PhoneCodeDTO phoneCodeDTO) throws Exception {
        userService.setPhoneNumber(userDTO, phoneCodeDTO);
        return new ResultVO<>();
    }

    @GetMapping("/getUsersByUserIdList")
    public ResultVO getUsersByUserIdList(UserDTO userDTO) throws Exception {
        return new ResultVO<>(userService.selectByUserIdList(userDTO));
    }

    @GetMapping("/getUser")
    public ResultVO getOne(UserDTO userDTO) {
        return new ResultVO<>(userService.selectByPrimary(userDTO));
    }

    @GetMapping("/getUsers")
    public ResultVO getAll() {
        return new ResultVO<>(userService.selectAll());
    }

    @PostMapping("/addUser")
    public ResultVO addOne(UserDTO userDTO) throws Exception {
        userService.insert(userDTO);
        return new ResultVO<>();
    }

    @PutMapping("/updateUser")
    public ResultVO updateOne(UserDTO userDTO) {
        userService.updateByPrimary(userDTO);
        return new ResultVO<>();
    }

    public ResultVO deleteOne(UserDTO userDTO) {
        userService.deleteByPrimary(userDTO);
        return new ResultVO<>();
    }

    @GetMapping("/getUsersInIndex")
    public ResultVO getUsersInIndex(PageDTO pageDTO) {
        return new ResultVO<>(userService.selectInIndex(pageDTO));
    }

}
