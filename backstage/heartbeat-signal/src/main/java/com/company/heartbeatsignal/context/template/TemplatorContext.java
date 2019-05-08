package com.company.heartbeatsignal.context.template;

import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Liquid
 * @类名： SendTemplateContext
 * @描述：
 * @date 2019/4/14
 */
@Component("templatorContext")
public class TemplatorContext {

    @Autowired
    private SendTemplatorFactory sendTemplatorFactory;

    public void sendTemplate(BaseTemplateDTO baseTemplateDTO,String beanName) throws Exception {

        SendTemplator sendTemplator =sendTemplatorFactory.createSendTemplator(beanName);
        sendTemplator.sendTemplate(baseTemplateDTO);
    }


}
