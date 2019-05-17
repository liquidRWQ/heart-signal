package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.controller.infc.Cruder;
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
public class LabelController implements Cruder<LabelDTO> {

    @Autowired
    private LabelService labelService;

    @GetMapping("/getLabel")
    @Override
    public ResultBean getOne(LabelDTO labelDTO) {
        return new ResultBean<>(labelService.selectByPrimary(labelDTO));
    }

    @GetMapping("/getLabels")
    @Override
    public ResultBean getAll() {
        return new ResultBean<>(labelService.selectAll());
    }

    @PostMapping("/addLabel")
    @Override
    public ResultBean addOne(LabelDTO labelDTO) throws Exception {
        labelService.insert(labelDTO);
        return new ResultBean<>();
    }

    @PutMapping("/updateLabel")
    @Override
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
    @Override
    public ResultBean deleteOne(LabelDTO labelDTO) {
        labelService.deleteByPrimary(labelDTO);
        return new ResultBean<>();
    }
}
