package com.company.heartbeatsignal.context.template.enterprise;

import com.company.heartbeatsignal.context.template.SendTemplator;
import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import com.company.heartbeatsignal.exception.CheckedException;

/**
 * @author Liquid
 * @类名： EnterpriseWeChatTemplator
 * @描述：
 * @date 2019/4/14
 */
public abstract class BaseEpsSendTemplator implements SendTemplator {
    @Override
    public void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException {

    }
}
