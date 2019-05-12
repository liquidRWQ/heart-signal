package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
