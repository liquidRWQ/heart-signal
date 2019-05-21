package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.BadReportDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.BadReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Liquid
 * @类名： BadReportController
 * @描述：
 * @date 2019/5/8
 */
@RequestMapping("/badReport")
@RestController
public class BadReportController {

    @Autowired
    private BadReportService badReportService;

    @GetMapping("/getBadReport")
    public ResultBean getOne(BadReportDTO badReportDTO) {
        return new ResultBean<>(badReportService.selectByPrimary(badReportDTO));
    }


    @GetMapping("/getBadReports")
    public ResultBean getAll() {
        return new ResultBean<>(badReportService.selectAll());
    }

    @PostMapping("/addBadReport")
    public ResultBean addOne(BadReportDTO badReportDTO) throws Exception {
        badReportService.insert(badReportDTO);
        return new ResultBean<>();
    }

    @PutMapping("/updateBadReport")
    public ResultBean updateOne(BadReportDTO badReportDTO) {
        badReportService.updateByPrimary(badReportDTO);
        return new ResultBean<>();
    }

    @DeleteMapping("/deleteBadReport")
    public ResultBean deleteOne(BadReportDTO badReportDTO) {
        badReportService.deleteByPrimary(badReportDTO);
        return new ResultBean<>();
    }

    @PostMapping("/setBadReport")
    public ResultBean setBadReport(BadReportDTO badReportDTO, @RequestParam("files") MultipartFile[] files , HttpServletRequest httpServletRequest) throws Exception {

        String realPath = httpServletRequest.getSession().getServletContext().getRealPath("/");
        badReportService.insertBadReportDTO(badReportDTO, realPath, files);
        return new ResultBean<>();
    }
}
