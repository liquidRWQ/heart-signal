package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.controller.infc.Cruder;
import com.company.heartbeatsignal.dto.entity.VisitorDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Liquid
 * @类名： VisitorController
 * @描述：
 * @date 2019/5/8
 */
@RequestMapping("/visitor")
@RestController
public class VisitorController implements Cruder<VisitorDTO> {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/getVisitor")
    @Override
    public ResultBean getOne(VisitorDTO visitorDTO) {

        return new ResultBean<VisitorDTO>(visitorService.selectByPrimary(visitorDTO));
    }

    @GetMapping("/getVisitors")
    @Override
    public ResultBean getAll() {
        return new ResultBean<List<VisitorDTO>>(visitorService.selectAll());
    }

    @PostMapping("/addVisitor")
    @Override
    public ResultBean addOne(VisitorDTO visitorDTO) throws Exception {
        visitorService.insert(visitorDTO);
        return new ResultBean<>();
    }

    @PutMapping("/updateVisitor")
    @Override
    public ResultBean updateOne(VisitorDTO visitorDTO) {
        visitorService.updateByPrimary(visitorDTO);
        return new ResultBean<>();
    }

    @DeleteMapping("/deleteVisitor")
    @Override
    public ResultBean deleteOne(VisitorDTO visitorDTO) {
        visitorService.deleteByPrimary(visitorDTO);
        return new ResultBean<>();
    }

    @GetMapping("/getVisitorByUserId")
    public ResultBean getVisitorByUserId(VisitorDTO visitorDTO) {

        return new ResultBean<>(visitorService.selectByUserId(visitorDTO));
    }

    @GetMapping("/getVisitorByVisitorUserId")
    public ResultBean getVisitorByVisitorUserId(VisitorDTO visitorDTO) {
        return new ResultBean<>(visitorService.selectByVisitorUserId(visitorDTO));
    }
}
