package com.company.heartbeatsignal.context.template.enterprise.feedback;

import com.company.heartbeatsignal.context.template.enterprise.BaseEpsSendTemplator;
import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import org.springframework.stereotype.Component;

/**
 * @author Liquid
 * @类名： EpsFeedbackSendTemplator
 * @描述：
 * @date 2019/4/16
 */
@Component("EpsFeedbackSend")
public class EpsFeedbackSendTemplator extends BaseEpsSendTemplator {
    @Override
    public void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException {
        super.sendTemplate(baseTemplateDTO);
    }
}
