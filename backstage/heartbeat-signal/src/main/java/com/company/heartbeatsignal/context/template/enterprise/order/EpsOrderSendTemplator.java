package com.company.heartbeatsignal.context.template.enterprise.order;

import com.company.heartbeatsignal.context.template.enterprise.BaseEpsSendTemplator;
import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import org.springframework.stereotype.Component;

/**
 * @author Liquid
 * @类名： EpsOrderSendTemplator
 * @描述：
 * @date 2019/4/16
 */
@Component("EpsOrderSend")
public class EpsOrderSendTemplator extends BaseEpsSendTemplator {
    @Override
    public void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException {
        super.sendTemplate(baseTemplateDTO);
    }
}
