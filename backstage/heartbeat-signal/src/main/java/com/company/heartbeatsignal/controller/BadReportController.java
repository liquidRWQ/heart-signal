package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.entity.BadReportDTO;
import com.company.heartbeatsignal.service.BadReportService;
import com.company.heartbeatsignal.vo.ResultVO;
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
@RestController
public class BadReportController {



    @Autowired
    private BadReportService badReportService;

    @GetMapping("/getBadReport")
    public ResultVO getOne(BadReportDTO badReportDTO) {
        return new ResultVO<>(badReportService.selectByPrimary(badReportDTO));
    }


    @GetMapping("/getBadReports")
    public ResultVO getAll() {
        return new ResultVO<>(badReportService.selectAll());
    }

    @PostMapping("/addBadReport")
    public ResultVO addOne(BadReportDTO badReportDTO) throws Exception {
        badReportService.insert(badReportDTO);
        return new ResultVO<>();
    }

    @PutMapping("/updateBadReport")
    public ResultVO updateOne(BadReportDTO badReportDTO) {
        badReportService.updateByPrimary(badReportDTO);
        return new ResultVO<>();
    }

    @DeleteMapping("/deleteBadReport")
    public ResultVO deleteOne(BadReportDTO badReportDTO) {
        badReportService.deleteByPrimary(badReportDTO);
        return new ResultVO<>();
    }

    @PostMapping("/setBadReport")
    public ResultVO setBadReport(BadReportDTO badReportDTO, @RequestParam("files") MultipartFile[] files , HttpServletRequest httpServletRequest) throws Exception {

        String realPath = httpServletRequest.getSession().getServletContext().getRealPath("/");
        badReportService.insertBadReportDTO(badReportDTO, realPath, files);
        return new ResultVO<>();
    }
}
