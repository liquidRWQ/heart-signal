package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.AttentionDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Liquid
 * @类名： AttentionController
 * @描述：
 * @date 2019/5/8
 */
@RestController
public class AttentionController{

    @Autowired
    private AttentionService attentionService;

    @GetMapping("/getAttention")
    public ResultBean getOne(AttentionDTO attentionDTO) {
        return new ResultBean<>(attentionService.selectByPrimary(attentionDTO));
    }

    @GetMapping("/getAttentions")
    public ResultBean getAll() {
        return new ResultBean<>(attentionService.selectAll());
    }

    @PostMapping("/addAttention")
    public ResultBean addOne(AttentionDTO attentionDTO) throws Exception {
        attentionService.insert(attentionDTO);
        return new ResultBean<>();
    }

    @PutMapping("/updateAttention")
    public ResultBean updateOne(AttentionDTO attentionDTO) {
        attentionService.updateByPrimary(attentionDTO);
        return new ResultBean<>();
    }


    @DeleteMapping("/deleteAttention")
    public ResultBean deleteOne(AttentionDTO attentionDTO) {
        attentionService.deleteByPrimary(attentionDTO);
        return new ResultBean<>();
    }


    @GetMapping("/getUsersByUserId")
    public ResultBean getUsersByUserId(AttentionDTO attentionDTO) {
        return new ResultBean<>(attentionService.selectByUserId(attentionDTO));
    }

    @GetMapping("/getUsersByAttentionUserId")
    public ResultBean getUsersByAttentionUserId(AttentionDTO attentionDTO) {
        return new ResultBean<>(attentionService.selectByAttentionUserId(attentionDTO));
    }
}
