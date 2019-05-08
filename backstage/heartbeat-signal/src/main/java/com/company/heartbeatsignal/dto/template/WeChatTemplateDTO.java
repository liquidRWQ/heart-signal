package com.company.heartbeatsignal.dto.template;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Liquid
 * @类名： OrderTemplateDTO
 * @描述：
 * @date 2019/4/14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WeChatTemplateDTO extends BaseTemplateDTO{
    String egg;
}
