package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.VipDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Liquid
 * @类名： VipController
 * @描述：
 * @date 2019/5/8
 */

@RestController
public class VipController {

    @Autowired
    private VipService vipService;

    @GetMapping("/getVip")
    public ResultBean getOne(VipDTO vipDTO) {
        return new ResultBean<>(vipService.selectByPrimary(vipDTO));
    }

    @GetMapping("/getVips")
    public ResultBean getAll() {
        return new ResultBean<>(vipService.selectAll());
    }

    @PostMapping("/addVip")
    public ResultBean addOne(VipDTO vipDTO) throws Exception {
        vipService.insert(vipDTO);
        return new ResultBean<>();
    }



    @PutMapping("/updateVip")
    public ResultBean updateOne(VipDTO vipDTO) {
        vipService.updateByPrimary(vipDTO);
        return new ResultBean<>();
    }

    @DeleteMapping("/deleteVip")
    public ResultBean deleteOne(VipDTO vipDTO) {
        vipService.deleteByPrimary(vipDTO);
        return new ResultBean<>();
    }

    @GetMapping("/getVipByUserId")
    public ResultBean getVipByUserId(VipDTO vipDTO) {
        return new ResultBean<>(vipService.selectByUserId(vipDTO));
    }
}
