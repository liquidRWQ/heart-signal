package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.VipOrderDTO;
import com.company.heartbeatsignal.vo.ResultVO;
import com.company.heartbeatsignal.service.VipOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Liquid
 * @类名： VipOrderController
 * @描述：
 * @date 2019/5/17
 */

@RestController
public class VipOrderController  {

    @Autowired
    private VipOrderService vipOrderService;

    @GetMapping("/getVipOrder")
    public ResultVO getOne(VipOrderDTO vipOrderDTO) {
        return new ResultVO<>(vipOrderService.selectByPrimary(vipOrderDTO));
    }
    @GetMapping("/getVipOrders")
    public ResultVO getAll() {
        return new ResultVO<>(vipOrderService.selectAll());
    }
    @PostMapping("/addOrder")
    public ResultVO addOne(VipOrderDTO vipOrderDTO) throws Exception {
        vipOrderService.insert(vipOrderDTO);
        return new ResultVO<>();
    }
    @PutMapping("/updateOrder")
    public ResultVO updateOne(VipOrderDTO vipOrderDTO) {
        vipOrderService.updateByPrimary(vipOrderDTO);
        return new ResultVO<>();
    }

    @DeleteMapping("/deleteOrder")
    public ResultVO deleteOne(VipOrderDTO vipOrderDTO) {
        vipOrderService.deleteByPrimary(vipOrderDTO);
        return new ResultVO<>();
    }
}
