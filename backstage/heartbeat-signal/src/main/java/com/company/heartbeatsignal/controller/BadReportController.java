package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.service.BadReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
