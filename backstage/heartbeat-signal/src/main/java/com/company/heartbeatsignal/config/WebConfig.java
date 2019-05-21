package com.company.heartbeatsignal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Liquid
 * @类名： WebConfig
 * @描述：
 * @date 2019/5/18
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
  /*  @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/imgs")
        .excludePathPatterns("/userphoto");
        super.addInterceptors(registry);
    }*/
}
