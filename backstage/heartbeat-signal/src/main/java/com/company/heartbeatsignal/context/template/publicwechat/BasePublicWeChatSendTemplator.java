package com.company.heartbeatsignal.context.template.publicwechat;

import com.company.heartbeatsignal.context.template.SendTemplator;
import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.exception.UnCheckedException;
import com.company.heartbeatsignal.util.HttpUrlUtils;
import com.company.heartbeatsignal.util.JsonUtils;

/**
 * @author Liquid
 * @类名： PublicWeChatSendTemplator
 * @描述：
 * @date 2019/4/14
 */

public abstract class BasePublicWeChatSendTemplator implements SendTemplator {

    private static final String CORRECT_CODE = "0";

    private static final String PUBLIC_WE_APP_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";


    @Override
    public void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException {
        String params = baseTemplateDTO.getParams();
        String result = HttpUrlUtils.sendPostJson(PUBLIC_WE_APP_URL, params);
        String errcode = JsonUtils.toJSONObject(result).get("errcode").toString();
        if (!CORRECT_CODE.equals(errcode)) {
            throw new UnCheckedException("发送微信公众号模板通知失败--调用对象的类：" + this.getClass() + "错误信息：" +
                    JsonUtils.toJSONObject(result).get("errcode").toString());
        }
    }
}
