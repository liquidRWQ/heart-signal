package com.company.heartbeatsignal.service.impl;

import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.AttentionMapper;
import com.company.heartbeatsignal.dao.database.mysql.mybatis.mapper.VisitorMapper;
import com.company.heartbeatsignal.dto.other.AccountDTO;
import com.company.heartbeatsignal.entity.Attention;
import com.company.heartbeatsignal.entity.Visitor;
import com.company.heartbeatsignal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Liquid
 * @类名： AccountServiceImpl
 * @描述：
 * @date 2019/5/20
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AttentionMapper attentionMapper;

    @Autowired
    private VisitorMapper visitorMapper;




    @Override
    public AccountDTO selectAttentionAndVisitorAccount(AccountDTO accountDTO) {

        Visitor visitor = new Visitor();
        visitor.setUserId(accountDTO.getUserId());
        accountDTO.setVisitorAccount(visitorMapper.selectCount(visitor));
        Attention attention = new Attention();
        attention.setUserId(accountDTO.getUserId());
        accountDTO.setAttentionAccount(attentionMapper.selectCount(attention));
        attention.setUserId(null);
        attention.setAttentionUserId(accountDTO.getUserId());
        accountDTO.setAttentionedAccount(attentionMapper.selectCount(attention));
        return accountDTO;
    }
}
