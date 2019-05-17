package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.controller.infc.Cruder;
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
@RequestMapping("/vip")
@RestController
public class VipController implements Cruder<VipDTO> {

    @Autowired
    private VipService vipService;

    @GetMapping("/getVip")
    @Override
    public ResultBean getOne(VipDTO vipDTO) {
        return new ResultBean<>(vipService.selectByPrimary(vipDTO));
    }

    @GetMapping("/getVips")
    @Override
    public ResultBean getAll() {
        return new ResultBean<>(vipService.selectAll());
    }

    @PostMapping("/addVip")
    @Override
    public ResultBean addOne(VipDTO vipDTO) throws Exception {
        vipService.insert(vipDTO);
        return new ResultBean<>();
    }

    @PutMapping("/updateVip")
    @Override
    public ResultBean updateOne(VipDTO vipDTO) {
        vipService.updateByPrimary(vipDTO);
        return new ResultBean<>();
    }

    @DeleteMapping("/deleteVip")
    @Override
    public ResultBean deleteOne(VipDTO vipDTO) {
        vipService.deleteByPrimary(vipDTO);
        return new ResultBean<>();
    }

    @GetMapping("/getVipByUserId")
    public ResultBean getVipByUserId(VipDTO vipDTO) {
        return new ResultBean<>(vipService.selectByUserId(vipDTO));
    }
}
