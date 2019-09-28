package com.company.heartbeatsignal.controller;

import com.company.heartbeatsignal.context.pay.PayContext;
import com.company.heartbeatsignal.dto.other.PayDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Liquid
 * @类名： PayController
 * @描述：
 * @date 2019/5/25
 */
@RestController
public class PayController {

    @Autowired
    private PayContext payContext;

    @GetMapping("/weChatPay")
    public ResultVO weChatPay(PayDTO payDTO, HttpServletRequest httpServletRequest) throws CheckedException {
        payDTO.setIp(getIp(httpServletRequest));
        payContext.pay(payDTO, "weChatPay");
        return new ResultVO<>(payDTO);
    }

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }
}
