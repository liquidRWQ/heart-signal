package com.company.heartbeatsignal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className WelcomeController
 * @auther Liquid
 * @description
 * @date 2018/12/26
 */
@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome() {
        return "项目部署成功";
    }

}
