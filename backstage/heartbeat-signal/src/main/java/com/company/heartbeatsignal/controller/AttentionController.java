package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.AttentionDTO;
import com.company.heartbeatsignal.vo.ResultVO;
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
    public ResultVO getOne(AttentionDTO attentionDTO) {
        return new ResultVO<>(attentionService.selectByPrimary(attentionDTO));
    }

    @GetMapping("/getAttentions")
    public ResultVO getAll() {
        return new ResultVO<>(attentionService.selectAll());
    }

    @PostMapping("/addAttention")
    public ResultVO addOne(AttentionDTO attentionDTO) throws Exception {
        attentionService.insert(attentionDTO);
        return new ResultVO<>();
    }

    @PutMapping("/updateAttention")
    public ResultVO updateOne(AttentionDTO attentionDTO) {
        attentionService.updateByPrimary(attentionDTO);
        return new ResultVO<>();
    }


    @DeleteMapping("/deleteAttention")
    public ResultVO deleteOne(AttentionDTO attentionDTO) {
        attentionService.deleteByPrimary(attentionDTO);
        return new ResultVO<>();
    }


    @GetMapping("/getUsersByUserId")
    public ResultVO getUsersByUserId(AttentionDTO attentionDTO) {
        return new ResultVO<>(attentionService.selectByUserId(attentionDTO));
    }

    @GetMapping("/getUsersByAttentionUserId")
    public ResultVO getUsersByAttentionUserId(AttentionDTO attentionDTO) {
        return new ResultVO<>(attentionService.selectByAttentionUserId(attentionDTO));
    }
}
