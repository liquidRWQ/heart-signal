package com.company.heartbeatsignal.service;

import com.company.heartbeatsignal.dto.other.AccountDTO;

/**
 * @author Liquid
 * @类名： AccountService
 * @描述：
 * @date 2019/5/20
 */
public interface AccountService {

        AccountDTO selectAttentionAndVisitorAccount(AccountDTO accountDTO);
}
