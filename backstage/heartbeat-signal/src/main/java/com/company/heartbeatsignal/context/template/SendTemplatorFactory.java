package com.company.heartbeatsignal.context.template;

/**
 * @author Liquid
 * @类名： TemplatorFactory
 * @描述：
 * @date 2019/4/16
 */
public interface SendTemplatorFactory {

    SendTemplator createSendTemplator(String beanName);


}
