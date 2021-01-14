package com.piao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @PROJECT_NAME: url-short
 * @USER: Leishen
 * @DATE: 2021/1/8 下午 6:35
 * @DESCRIPTION:
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加自己的拦截器
        InterceptorRegistration interceptor = registry.addInterceptor(new RequestHandlerIntercepter());
        /*
         * addPathPatterns 表示拦截某些请求
         * excludePathPatterns 表示不拦截某些请求
         **/

/*      //拦截所有
        interceptor.addPathPatterns("/**");
        //不拦截首页
        interceptor.excludePathPatterns("/index.html");
        //不拦截错误页面
        interceptor.excludePathPatterns("/error.html");
        //不拦截跳转首页的请求
        interceptor.excludePathPatterns("/");*/
    }


}
