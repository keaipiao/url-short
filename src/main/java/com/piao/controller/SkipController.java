package com.piao.controller;

import com.piao.common.Const;
import com.piao.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @PROJECT_NAME: url-short
 * @USER: Leishen
 * @DATE: 2021/1/8 下午 6:21
 * @DESCRIPTION: 跳转使用的controller
 */
@Controller
public class SkipController {

    @Autowired
    private UrlService urlService;

    //跳转首页
    @GetMapping("/")
    public String goToIndex(){
        System.out.println("hello");
        return "index.html";
    }

    //重定向到长链接
    @GetMapping("/tz/{shortUrl}")
    public String test(@PathVariable(name = "shortUrl") String shortUrl){
        String longUrl = urlService.getLongUrl(shortUrl);
        return "redirect:" + (longUrl != null ? longUrl : Const.HOST + "error.html");
    }
}
