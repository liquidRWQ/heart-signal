package com.company.heartbeatsignal.aop;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @className SpringControllerAdvice
 * @auther Liquid
 * @description
 * @date 2018/12/23
 */
@RestControllerAdvice
public class SpringControllerAdvice {
    @InitBinder
    public void dateInitBinder(WebDataBinder binder) {
        /**
         * @auther Liquid
         *
         * @param [binder]
         *
         * @description  将请求参数的date=yyyy-MM-dd 转换成java date类型
         *
         * @return
         *
         * @date 2018/12/23
         */
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm"));
    }

    /*@InitBinder
    public void webInitBinder(WebDataBinder binder) {
        *
         * @auther Liquid
         *
         * @param [binder]
         *
         * @description  将请求参数的date=yyyy-MM-dd 转换成java date类型
         *
         * @return
         *
         * @date 2018/12/23

        binder.registerCustomEditor(String.class,new StringEditor());
    }

    public class StringEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (StringUtils.isBlank(text)) {
                return;
            }
            try {
                //Spring自带html标签转义与反转义
                super.setValue(HtmlUtils.htmlEscape(text));
            } catch (Exception e) {
                throw new IllegalArgumentException("非法参数异常"+e);
            }
        }
    }*/
}
