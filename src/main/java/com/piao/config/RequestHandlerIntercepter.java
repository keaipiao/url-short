package com.piao.config;

import com.piao.common.Const;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @PROJECT_NAME: url-short
 * @USER: Leishen
 * @DATE: 2021/1/8 下午 6:32
 * @DESCRIPTION:
 */


public class RequestHandlerIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断主机/后的长度是否与短链接的长度相同，如果相同则拦截，否则放行
        String uri = request.getRequestURI().substring(1);
        //判断uri的长度和短链接的长度是否一致，并判断uri是否包含. 或 / 则拦截
        if(uri.length() == Const.SHORT_URL_LENGTH.intValue() && !uri.contains(".") && !uri.contains("/")){
            //转发到Controller
            request.getRequestDispatcher("/tz/" + uri).forward(request,response);
            return false;
        }
        return true;
    }
}
