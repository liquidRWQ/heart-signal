package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.dto.other.AccountDTO;
import com.company.heartbeatsignal.result.ResultBean;
import com.company.heartbeatsignal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liquid
 * @类名： AccountController
 * @描述：
 * @date 2019/5/20
 */
@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/getAttentionAndVisitorAccountByUserId")
    public ResultBean getOne(AccountDTO accountDTO) {
        return new ResultBean<>(accountService.selectAttentionAndVisitorAccount(accountDTO));
    }
}
