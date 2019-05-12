package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liquid
 * @类名： VisitorController
 * @描述：
 * @date 2019/5/8
 */
@RequestMapping("/visitor")
@RestController
public class VisitorController {

    @Autowired
    private VisitorService visitorService;


}
