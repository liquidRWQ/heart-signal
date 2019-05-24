package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.CdkDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.CdkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Liquid
 * @类名： CdkController
 * @描述：
 * @date 2019/5/8
 */
@RestController
public class CdkController {

    @Autowired
    private CdkService cdkService;


    @GetMapping("/getCdk")
    public ResultBean getOne(CdkDTO cdkDTO) {

        return new ResultBean<>(cdkService.selectByPrimary(cdkDTO));
    }

    @GetMapping("/getCdks")
    public ResultBean getAll() {
        return new ResultBean<>(cdkService.selectAll());
    }

    @PostMapping("/addCdk")
    public ResultBean addOne(CdkDTO cdkDTO) throws Exception {
        cdkService.insert(cdkDTO);
        return new ResultBean<>();
    }

    @PutMapping("/updateCdk")
    public ResultBean updateOne(CdkDTO cdkDTO) {
        cdkService.updateByPrimary(cdkDTO);
        return new ResultBean<>();
    }

    @DeleteMapping("/deleteCdk")
    public ResultBean deleteOne(CdkDTO cdkDTO) {
        cdkService.deleteByPrimary(cdkDTO);
        return new ResultBean<>();
    }

    @DeleteMapping("/convertCdk")
    public ResultBean convertCdk(CdkDTO cdkDTO) {
        cdkService.convertCdk(cdkDTO);
        return new ResultBean<>();
    }
}
