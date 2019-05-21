package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.VipOrderDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.VipOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Liquid
 * @类名： VipOrderController
 * @描述：
 * @date 2019/5/17
 */
@RequestMapping("/vipOrder")
@RestController
public class VipOrderController  {

    @Autowired
    private VipOrderService vipOrderService;

    @GetMapping("/getVipOrder")
    public ResultBean getOne(VipOrderDTO vipOrderDTO) {
        return new ResultBean<>(vipOrderService.selectByPrimary(vipOrderDTO));
    }
    @GetMapping("/getVipOrders")
    public ResultBean getAll() {
        return new ResultBean<>(vipOrderService.selectAll());
    }
    @PostMapping("/addOrder")
    public ResultBean addOne(VipOrderDTO vipOrderDTO) throws Exception {
        vipOrderService.insert(vipOrderDTO);
        return new ResultBean<>();
    }
    @PutMapping("/updateOrder")
    public ResultBean updateOne(VipOrderDTO vipOrderDTO) {
        vipOrderService.updateByPrimary(vipOrderDTO);
        return new ResultBean<>();
    }

    @DeleteMapping("/deleteOrder")
    public ResultBean deleteOne(VipOrderDTO vipOrderDTO) {
        vipOrderService.deleteByPrimary(vipOrderDTO);
        return new ResultBean<>();
    }
}
