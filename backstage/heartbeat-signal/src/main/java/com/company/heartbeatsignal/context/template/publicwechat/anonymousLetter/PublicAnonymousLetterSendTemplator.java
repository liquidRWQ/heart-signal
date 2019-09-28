package com.company.heartbeatsignal.context.template.publicwechat.anonymousLetter;

import com.company.heartbeatsignal.context.template.publicwechat.BasePublicWeChatSendTemplator;
import com.company.heartbeatsignal.dto.template.BaseTemplateDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import org.springframework.stereotype.Component;

/**
 * @author Liquid
 * @类名： PublicAnonymousLetterSendTemplator
 * @描述：
 * @date 2019/6/17
 */
@Component("publicAnonymousLetterSend")
public class PublicAnonymousLetterSendTemplator extends BasePublicWeChatSendTemplator {

    @Override
    public void sendTemplate(BaseTemplateDTO baseTemplateDTO) throws CheckedException {

        String first = baseTemplateDTO.getFirst();
        String second = baseTemplateDTO.getSecond();
        String third = baseTemplateDTO.getThird();
        String fourth = baseTemplateDTO.getFourth();
        String fifth = baseTemplateDTO.getFifth();

        super.sendTemplate(baseTemplateDTO);
    }
}
