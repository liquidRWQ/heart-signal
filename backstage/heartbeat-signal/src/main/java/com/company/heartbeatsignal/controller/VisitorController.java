package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.VisitorDTO;
import com.company.heartbeatsignal.vo.ResultVO;
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

@RestController
public class VisitorController  {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/getVisitor")
    public ResultVO getOne(VisitorDTO visitorDTO) {

        return new ResultVO<VisitorDTO>(visitorService.selectByPrimary(visitorDTO));
    }

    @GetMapping("/getVisitors")
    public ResultVO getAll() {
        return new ResultVO<List<VisitorDTO>>(visitorService.selectAll());
    }

    @PostMapping("/addVisitor")
    public ResultVO addOne(VisitorDTO visitorDTO) throws Exception {
        visitorService.insert(visitorDTO);
        return new ResultVO<>();
    }

    @PutMapping("/updateVisitor")
    public ResultVO updateOne(VisitorDTO visitorDTO) {
        visitorService.updateByPrimary(visitorDTO);
        return new ResultVO<>();
    }

    @DeleteMapping("/deleteVisitor")
    public ResultVO deleteOne(VisitorDTO visitorDTO) {
        visitorService.deleteByPrimary(visitorDTO);
        return new ResultVO<>();
    }

    @GetMapping("/getVisitorByUserId")
    public ResultVO getVisitorByUserId(VisitorDTO visitorDTO) {

        return new ResultVO<>(visitorService.selectByUserId(visitorDTO));
    }

    @GetMapping("/getVisitorByVisitorUserId")
    public ResultVO getVisitorByVisitorUserId(VisitorDTO visitorDTO) {
        return new ResultVO<>(visitorService.selectByVisitorUserId(visitorDTO));
    }
}
