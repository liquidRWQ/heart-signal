package com.company.heartbeatsignal.context.template.wechat.feedback;

import com.company.heartbeatsignal.context.template.wechat.BaseWeChatSendTemplator;
import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import org.springframework.stereotype.Component;

/**
 * @author Liquid
 * @类名： WeChatFeedbackSendTemplator
 * @描述：
 * @date 2019/4/16
 */
@Component("WeChatFeedbackSend")
public class WeChatFeedbackSendTemplator extends BaseWeChatSendTemplator {

    public WeChatFeedbackSendTemplator() {

    }

    @Override
    public void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException {
        super.sendTemplate(baseTemplateDTO);
    }
}
