package com.company.heartbeatsignal.context.template.wechat;

import com.company.heartbeatsignal.context.template.SendTemplator;
import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.exception.UnCheckedException;
import com.company.heartbeatsignal.util.HttpUrlUtils;
import com.company.heartbeatsignal.util.JsonUtils;

/**
 * @author Liquid
 * @类名： WeChatSendTemplator
 * @描述：
 * @date 2019/4/14
 */
public class BaseWeChatSendTemplator implements SendTemplator {

    private static final String CORRECT_CODE = "0";

    private static final String WE_APP_URL = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=";

    protected  BaseWeChatSendTemplator() {

    }

    @Override
    public void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException {
        String params = baseTemplateDTO.getParams();
        String result = HttpUrlUtils.sendPostJson(WE_APP_URL, params);
        String errcode = JsonUtils.toJSONObject(result).get("errcode").toString();
        if (!BaseWeChatSendTemplator.CORRECT_CODE.equals(errcode)) {
            throw new UnCheckedException("发送微信模板通知失败--调用对象的类：" + this.getClass() + "错误信息：" +
                    JsonUtils.toJSONObject(result).get("errcode").toString());
        }
    }
}
