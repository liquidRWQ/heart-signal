package com.company.heartbeatsignal.context.template.wechat.error;

import com.company.heartbeatsignal.context.template.wechat.BaseWeChatSendTemplator;
import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import org.springframework.stereotype.Component;

/**
 * @author Liquid
 * @类名： WeChatErrorSendTemplator
 * @描述：
 * @date 2019/4/16
 */
@Component("WeChatErrorSend")
public class WeChatErrorSendTemplator extends BaseWeChatSendTemplator {

    public WeChatErrorSendTemplator() {

    }

    @Override
    public void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException {
        super.sendTemplate(baseTemplateDTO);
    }
}