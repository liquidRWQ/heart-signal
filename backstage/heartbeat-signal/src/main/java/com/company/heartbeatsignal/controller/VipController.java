package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liquid
 * @类名： VipController
 * @描述：
 * @date 2019/5/8
 */
@RequestMapping("/vip")
@RestController
public class VipController {

    @Autowired
    private VipService vipService;
}
