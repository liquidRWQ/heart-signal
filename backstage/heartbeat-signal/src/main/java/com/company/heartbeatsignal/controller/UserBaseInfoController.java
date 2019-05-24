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
@RestController
public class UserBaseInfoController {

    @Autowired
    private UserBaseInfoService userBaseInfoService;

    @GetMapping("/getUserBaseInfo")
    public ResultBean getOne(UserBaseInfoDTO userBaseInfoDTO) {
        return new ResultBean<>(userBaseInfoService.selectByPrimary(userBaseInfoDTO));
    }

    @GetMapping("getUserBaseInfos")
    public ResultBean getAll() {
        return new ResultBean<>(userBaseInfoService.selectAll());
    }

    @PostMapping("/addUserBaseInfo")
    public ResultBean addOne(UserBaseInfoDTO userBaseInfoDTO) throws Exception {
        userBaseInfoService.insert(userBaseInfoDTO);
        return new ResultBean<>();
    }

    @PutMapping("/updateUserBaseInfo")
    public ResultBean updateOne(UserBaseInfoDTO userBaseInfoDTO) {
        userBaseInfoService.updateByPrimary(userBaseInfoDTO);
        return new ResultBean<>();
    }

    public ResultBean deleteOne(UserBaseInfoDTO userBaseInfoDTO) {
        userBaseInfoService.deleteByPrimary(userBaseInfoDTO);
        return new ResultBean<>();
    }

    @GetMapping("/getUserBaseInfoByUserId")
    public ResultBean getUserBaseInfoByUserId(UserBaseInfoDTO userBaseInfoDTO) {
        return new ResultBean<>(userBaseInfoService.selectByUserId(userBaseInfoDTO));
    }
}
