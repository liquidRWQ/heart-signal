package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.VipDTO;
import com.company.heartbeatsignal.vo.ResultVO;
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
    public ResultVO getOne(VipDTO vipDTO) {
        return new ResultVO<>(vipService.selectByPrimary(vipDTO));
    }

    @GetMapping("/getVips")
    public ResultVO getAll() {
        return new ResultVO<>(vipService.selectAll());
    }

    @PostMapping("/addVip")
    public ResultVO addOne(VipDTO vipDTO) throws Exception {
        vipService.insert(vipDTO);
        return new ResultVO<>();
    }



    @PutMapping("/updateVip")
    public ResultVO updateOne(VipDTO vipDTO) {
        vipService.updateByPrimary(vipDTO);
        return new ResultVO<>();
    }

    @DeleteMapping("/deleteVip")
    public ResultVO deleteOne(VipDTO vipDTO) {
        vipService.deleteByPrimary(vipDTO);
        return new ResultVO<>();
    }

    @GetMapping("/getVipByUserId")
    public ResultVO getVipByUserId(VipDTO vipDTO) {
        return new ResultVO<>(vipService.selectByUserId(vipDTO));
    }
}
