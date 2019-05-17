package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.controller.infc.Cruder;
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
public class UserBaseInfoController implements Cruder<UserBaseInfoDTO> {

    @Autowired
    private UserBaseInfoService userBaseInfoService;

    @GetMapping("/getUserBaseInfo")
    @Override
    public ResultBean getOne(UserBaseInfoDTO userBaseInfoDTO) {
        return new ResultBean<>(userBaseInfoService.selectByPrimary(userBaseInfoDTO));
    }

    @GetMapping("getUserBaseInfos")
    @Override
    public ResultBean getAll() {
        return new ResultBean<>(userBaseInfoService.selectAll());
    }

    @PostMapping("/addUserBaseInfo")
    @Override
    public ResultBean addOne(UserBaseInfoDTO userBaseInfoDTO) throws Exception {
        userBaseInfoService.insert(userBaseInfoDTO);
        return new ResultBean<>();
    }

    @PutMapping("/updateUserBaseInfo")
    @Override
    public ResultBean updateOne(UserBaseInfoDTO userBaseInfoDTO) {
        userBaseInfoService.updateByPrimary(userBaseInfoDTO);
        return new ResultBean<>();
    }

    @Override
    public ResultBean deleteOne(UserBaseInfoDTO userBaseInfoDTO) {
        userBaseInfoService.deleteByPrimary(userBaseInfoDTO);
        return new ResultBean<>();
    }

    @GetMapping("/getUserBaseInfoByUserId")
    public ResultBean getUserBaseInfoByUserId(UserBaseInfoDTO userBaseInfoDTO) {
        return new ResultBean<>(userBaseInfoService.selectByUserId(userBaseInfoDTO));
    }
}
