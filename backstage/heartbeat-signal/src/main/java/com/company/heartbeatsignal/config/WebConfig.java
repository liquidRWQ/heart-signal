package com.company.heartbeatsignal.config;

import com.company.heartbeatsignal.interceptor.AccessControlInterceptor;
import com.company.heartbeatsignal.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final JwtInterceptor jwtInterceptor;

    private final AccessControlInterceptor accessControlInterceptor;

    @Autowired
    public WebConfig(JwtInterceptor jwtInterceptor, AccessControlInterceptor accessControlInterceptor) {
        this.jwtInterceptor = jwtInterceptor;
        this.accessControlInterceptor = accessControlInterceptor;
    }

  /*  @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/imgs")
                .excludePathPatterns("/files/** ");
        registry.addInterceptor(accessControlInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }*/
}
