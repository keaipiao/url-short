package com.piao.controller;

import com.piao.bean.Url;
import com.piao.common.CommonResult;
import com.piao.common.Const;
import com.piao.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @PROJECT_NAME: url-short
 * @USER: Leishen
 * @DATE: 2021/1/10 下午 3:46
 * @DESCRIPTION:
 */
@RestController
@RequestMapping("/url")
public class UrlController {
    @Autowired
    private UrlService urlService;

    //创建短链接
    @PostMapping("/createShortUrl")
    public CommonResult createShortUrl(String longUrl,Integer inDate){
        String shortUrl = urlService.createShortUrl(longUrl, inDate);
        if(shortUrl != null){
            return new CommonResult(true,"创建短链接成功", Const.HOST + shortUrl);
        }else{
            return new CommonResult(false,"创建短链接失败，请重试");
        }
    }

    //批量生成短链接
    @PostMapping("/createShortUrlList")
    public CommonResult createShortUrlList(String longUrlList,Integer inDate){
        String[] longUrls = longUrlList.split("\n");
        List<String> shortUrlList = urlService.createShortUrlList(longUrls, inDate);
        if(shortUrlList!=null){
            return new CommonResult(true,"创建短链接成功",shortUrlList);
        }else{
            return new CommonResult(false,"创建短链接失败");
        }

    }

    @GetMapping("/getLongUrl")
    public CommonResult getLongUrl(String shortUrl){
        String longUrl = urlService.getLongUrl(shortUrl);
        if(longUrl!=null){
            return new CommonResult(true,"获取长链接成功",longUrl);
        }else{
            return new CommonResult(false,"获取长连接失败");
        }
    }

    @GetMapping("/getShortDataList")
    public CommonResult getShortDataList(String shortUrlList){
        String[] shortUrls = shortUrlList.split("\n");
        List<Url> shortDataList = urlService.getShortDataList(shortUrls);
        if(shortDataList!=null){
            return new CommonResult(true,"获取短链接详情成功",shortDataList);
        }else{
            return new CommonResult(false,"获取短链接详情失败");
        }

    }
}
