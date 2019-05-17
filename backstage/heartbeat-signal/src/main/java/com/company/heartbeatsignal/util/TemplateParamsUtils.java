package com.company.heartbeatsignal.util;

import com.company.heartbeatsignal.dto.entity.VipOrderDTO;

import java.util.Date;

/**
 * @author Liquid
 * @类名： TemplateParamsUtils
 * @描述：
 * @date 2019/5/18
 */
public class TemplateParamsUtils {

    public static String getVipOrderJsonParams(VipOrderDTO vipOrderDTO) {
        Double orderPrice = vipOrderDTO.getOrderPrice();
        Date orderTime = vipOrderDTO.getOrderTime();
        String formId = vipOrderDTO.getFormId();
        return null;
    }
}
