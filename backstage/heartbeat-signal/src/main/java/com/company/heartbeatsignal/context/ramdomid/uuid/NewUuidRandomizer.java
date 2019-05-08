package com.company.heartbeatsignal.context.ramdomid.uuid;

import com.company.heartbeatsignal.context.ramdomid.StringRandomizer;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Liquid
 * @类名： NewUuidRandomizer
 * @描述：
 * @date 2019/4/14
 */
@Component("newUuid")
public class NewUuidRandomizer implements StringRandomizer {

    /**
     * @param
     * @return java.lang.String 时间的字符串
     * @throws null
     * @author Liquid
     * @描述： 获取当前格式化后的的时间的字符串
     * @date 2018/12/30
     */
    @Override
    public String getRandom() {
        return UUID.randomUUID().toString();
    }
}
