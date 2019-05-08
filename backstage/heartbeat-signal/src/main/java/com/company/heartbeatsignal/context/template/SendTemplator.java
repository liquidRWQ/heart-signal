package com.company.heartbeatsignal.context.template;

import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import com.company.heartbeatsignal.exception.CheckedException;

/**
 * @author Liquid
 * @类名： SendTemplator
 * @描述：
 * @date 2019/4/14
 */
public interface SendTemplator {

    void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException;
}
