package com.piao.service;

import com.piao.bean.Url;

import java.util.List;

/**
 * @PROJECT_NAME: url-short
 * @USER: Leishen
 * @DATE: 2021/1/8 下午 7:58
 * @DESCRIPTION:
 */
public interface UrlService {
    //创建短链接
    public String createShortUrl(String longUrl,Integer inDate);

    //批量创建短链接
    public List<String> createShortUrlList(String[] longUrls,Integer inDate);

    //短链接获取长链接
    public String getLongUrl(String shortUrl);

    //批量获取短链接详情
    public List<Url> getShortDataList(String[] shortUrls);
}
