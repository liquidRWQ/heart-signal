package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.CdkDTO;
import com.company.heartbeatsignal.vo.ResultVO;
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
    public ResultVO getOne(CdkDTO cdkDTO) {

        return new ResultVO<>(cdkService.selectByPrimary(cdkDTO));
    }

    @GetMapping("/getCdks")
    public ResultVO getAll() {
        return new ResultVO<>(cdkService.selectAll());
    }

    @PostMapping("/addCdk")
    public ResultVO addOne(CdkDTO cdkDTO) throws Exception {
        cdkService.insert(cdkDTO);
        return new ResultVO<>();
    }

    @PutMapping("/updateCdk")
    public ResultVO updateOne(CdkDTO cdkDTO) {
        cdkService.updateByPrimary(cdkDTO);
        return new ResultVO<>();
    }

    @DeleteMapping("/deleteCdk")
    public ResultVO deleteOne(CdkDTO cdkDTO) {
        cdkService.deleteByPrimary(cdkDTO);
        return new ResultVO<>();
    }

    @DeleteMapping("/convertCdk")
    public ResultVO convertCdk(CdkDTO cdkDTO) {
        cdkService.convertCdk(cdkDTO);
        return new ResultVO<>();
    }
}
