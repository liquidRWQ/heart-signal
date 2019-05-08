package com.company.heartbeatsignal.context.template.publicwechat.feedback;

import com.company.heartbeatsignal.context.template.publicwechat.BasePublicWeChatSendTemplator;
import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import org.springframework.stereotype.Component;

/**
 * @author Liquid
 * @类名： PublicFeedbackSendTemplator
 * @描述：
 * @date 2019/4/16
 */
@Component("publicFeedbackSend")
public class PublicFeedbackSendTemplator extends BasePublicWeChatSendTemplator{
    @Override
    public void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException {
        super.sendTemplate(baseTemplateDTO);
    }
}
