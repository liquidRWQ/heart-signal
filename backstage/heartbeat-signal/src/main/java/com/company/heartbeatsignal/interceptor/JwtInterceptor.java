package com.company.heartbeatsignal.interceptor;

import com.company.heartbeatsignal.exception.UnCheckedException;
import com.company.heartbeatsignal.util.JwtUtils;
import com.company.heartbeatsignal.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Liquid
 * @类名： JwtInterceptor
 * @描述：
 * @date 2019/5/18
 */
@Slf4j
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");
        if (StringUtils.isEmpty(token)) {
            log.warn("token为空: " + token + " 线程：" + Thread.currentThread().getName() + " 发送时间：" + TimeUtils.getCurrentTimeString());
            throw new UnCheckedException("token为空");
        }
        request.setAttribute("token",token );

        return super.preHandle(request, response, handler);
    }

}
