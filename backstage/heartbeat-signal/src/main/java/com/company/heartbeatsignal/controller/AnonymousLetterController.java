package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.service.AnonymousLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liquid
 * @类名： AnonymousLetterController
 * @描述：
 * @date 2019/5/8
 */
@RequestMapping("/anonymous")
@RestController
public class AnonymousLetterController {

    @Autowired
    private AnonymousLetterService anonymousLetterService;
}
