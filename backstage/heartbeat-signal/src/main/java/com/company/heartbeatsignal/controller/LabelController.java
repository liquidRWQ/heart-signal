package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.LabelDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Liquid
 * @类名： LabelController
 * @描述：
 * @date 2019/5/8
 */
@RequestMapping("/label")
@RestController
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping("/getLabel")
    public ResultBean getOne(LabelDTO labelDTO) {
        return new ResultBean<>(labelService.selectByPrimary(labelDTO));
    }

    @GetMapping("/getLabels")
    public ResultBean getAll() {
        return new ResultBean<>(labelService.selectAll());
    }

    @PostMapping("/addLabel")
    public ResultBean addOne(LabelDTO labelDTO) throws Exception {
        labelService.insert(labelDTO);
        return new ResultBean<>();
    }

    @PutMapping("/updateLabel")
    public ResultBean updateOne(LabelDTO labelDTO) {
        labelService.updateByPrimary(labelDTO);
        return new ResultBean<>();
    }

    @PutMapping("/updateLabelStatus")
    public ResultBean updateLabelStatus(LabelDTO labelDTO) {
        labelService.updateByPrimary(labelDTO);
        return new ResultBean<>();
    }

    @DeleteMapping("/deleteLabel")
    public ResultBean deleteOne(LabelDTO labelDTO) {
        labelService.deleteByPrimary(labelDTO);
        return new ResultBean<>();
    }

    @GetMapping("/getLabelsByUserId")
    public ResultBean getLabelsByUserId(LabelDTO labelDTO) {
        return new ResultBean<>(labelService.selectLabelsByUserId(labelDTO));
    }
}
