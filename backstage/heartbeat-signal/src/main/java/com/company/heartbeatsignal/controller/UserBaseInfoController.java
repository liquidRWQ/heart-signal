package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.UserBaseInfoDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.UserBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Liquid
 * @类名： UserBaseInfoController
 * @描述：
 * @date 2019/5/8
 */
@RequestMapping("/userBaseInfo")
@RestController
public class UserBaseInfoController {

    @Autowired
    private UserBaseInfoService userBaseInfoService;

    @PostMapping("/setUserBaseInfo")
    public ResultBean setUserBaseInfo(UserBaseInfoDTO userBaseInfoDTO){
        userBaseInfoService.addUserBaseInfo(userBaseInfoDTO);
        return new ResultBean();
    }

    @PutMapping("/updateUserBaseInfo")
    public ResultBean updateUserBaseInfo(UserBaseInfoDTO userBaseInfoDTO){
        userBaseInfoService.updateUserBaseInfo(userBaseInfoDTO);
        return new ResultBean();
    }

    @GetMapping("/getUserBaseInfo")
    public ResultBean getUserBaseInfo(UserBaseInfoDTO userBaseInfoDTO){
        return new ResultBean<UserBaseInfoDTO>(userBaseInfoService.getOneUserBaseInfo(userBaseInfoDTO));
    }
}
