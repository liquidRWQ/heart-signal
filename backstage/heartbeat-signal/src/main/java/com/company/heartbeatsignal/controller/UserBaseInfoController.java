package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.UserBaseInfoDTO;
import com.company.heartbeatsignal.vo.ResultVO;
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
    public ResultVO getOne(UserBaseInfoDTO userBaseInfoDTO) {
        return new ResultVO<>(userBaseInfoService.selectByPrimary(userBaseInfoDTO));
    }

    @GetMapping("getUserBaseInfos")
    public ResultVO getAll() {
        return new ResultVO<>(userBaseInfoService.selectAll());
    }

    @PostMapping("/addUserBaseInfo")
    public ResultVO addOne(UserBaseInfoDTO userBaseInfoDTO) throws Exception {
        userBaseInfoService.insert(userBaseInfoDTO);
        return new ResultVO<>();
    }

    @PutMapping("/updateUserBaseInfo")
    public ResultVO updateOne(UserBaseInfoDTO userBaseInfoDTO) {
        userBaseInfoService.updateByPrimary(userBaseInfoDTO);
        return new ResultVO<>();
    }

    public ResultVO deleteOne(UserBaseInfoDTO userBaseInfoDTO) {
        userBaseInfoService.deleteByPrimary(userBaseInfoDTO);
        return new ResultVO<>();
    }

    @GetMapping("/getUserBaseInfoByUserId")
    public ResultVO getUserBaseInfoByUserId(UserBaseInfoDTO userBaseInfoDTO) {
        return new ResultVO<>(userBaseInfoService.selectByUserId(userBaseInfoDTO));
    }
}
