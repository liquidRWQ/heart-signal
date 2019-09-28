package com.company.heartbeatsignal.context.token.mysql;

import com.company.heartbeatsignal.context.token.Token;
import com.company.heartbeatsignal.context.token.TokenStorager;
import org.springframework.stereotype.Component;

/**
 * @author Liquid
 * @类名： MysqlTokenStorager
 * @描述：
 * @date 2019/6/17
 */

@Component("mysqlTokenStorager")
public class MysqlTokenStorager implements TokenStorager{

    @Override
    public void tokenStorage(Token token) {
        System.out.println("存储 = " + token);
    }
}
