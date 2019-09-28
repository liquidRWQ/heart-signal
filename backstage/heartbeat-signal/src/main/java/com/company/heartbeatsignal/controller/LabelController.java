package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.LabelDTO;
import com.company.heartbeatsignal.vo.ResultVO;
import com.company.heartbeatsignal.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Liquid
 * @类名： LabelController
 * @描述：
 * @date 2019/5/8
 */
@RestController
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping("/getLabel")
    public ResultVO getOne(LabelDTO labelDTO) {
        return new ResultVO<>(labelService.selectByPrimary(labelDTO));
    }

    @GetMapping("/getLabels")
    public ResultVO getAll() {
        return new ResultVO<>(labelService.selectAll());
    }

    @PostMapping("/addLabel")
    public ResultVO addOne(LabelDTO labelDTO) throws Exception {
        labelService.insert(labelDTO);
        return new ResultVO<>();
    }

    @PutMapping("/updateLabel")
    public ResultVO updateOne(LabelDTO labelDTO) {
        labelService.updateByPrimary(labelDTO);
        return new ResultVO<>();
    }

    @PutMapping("/updateLabelStatus")
    public ResultVO updateLabelStatus(LabelDTO labelDTO) {
        labelService.updateByPrimary(labelDTO);
        return new ResultVO<>();
    }

    @DeleteMapping("/deleteLabel")
    public ResultVO deleteOne(LabelDTO labelDTO) {
        labelService.deleteByPrimary(labelDTO);
        return new ResultVO<>();
    }

    @GetMapping("/getLabelsByUserId")
    public ResultVO getLabelsByUserId(LabelDTO labelDTO) {
        return new ResultVO<>(labelService.selectLabelsByUserId(labelDTO));
    }
}
