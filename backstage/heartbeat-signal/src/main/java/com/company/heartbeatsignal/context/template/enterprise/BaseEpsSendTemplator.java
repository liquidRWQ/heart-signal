package com.company.heartbeatsignal.context.template.enterprise;

import com.company.heartbeatsignal.context.template.SendTemplator;
import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.exception.UnCheckedException;
import com.company.heartbeatsignal.util.HttpRequestUtils;
import com.company.heartbeatsignal.util.JsonUtils;

/**
 * @author Liquid
 * @类名： EnterpriseWeChatTemplator
 * @描述：
 * @date 2019/4/14
 */
public abstract class BaseEpsSendTemplator implements SendTemplator {

    private static final String CORRECT_CODE = "0";

    private static final String ENTERPRISE_WE_CHAT_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";

    @Override
    public void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException {
        String params = baseTemplateDTO.getParams();
        String result = HttpRequestUtils.sendPostJson(ENTERPRISE_WE_CHAT_URL, params);
        String errcode = JsonUtils.toJSONObject(result).get("errcode").toString();
        if (!CORRECT_CODE.equals(errcode)) {
            throw new UnCheckedException("发送企业微信模板通知失败--调用对象的类：" + this.getClass() + "错误信息：" +
                    JsonUtils.toJSONObject(result).get("errcode").toString());
        }
    }
}
