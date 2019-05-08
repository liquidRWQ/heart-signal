package com.company.heartbeatsignal.context.template.publicwechat.error;

import com.company.heartbeatsignal.context.template.publicwechat.BasePublicWeChatSendTemplator;
import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import org.springframework.stereotype.Component;

/**
 * @author Liquid
 * @类名： PublicErrorSendTemplator
 * @描述：
 * @date 2019/4/16
 */
@Component("publicErrorSend")
public class PublicErrorSendTemplator extends BasePublicWeChatSendTemplator {
    @Override
    public void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException {
        super.sendTemplate(baseTemplateDTO);
    }
}
