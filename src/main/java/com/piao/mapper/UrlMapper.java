package com.piao.mapper;

import com.piao.bean.Url;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @PROJECT_NAME: url-short
 * @USER: Leishen
 * @DATE: 2021/1/10 下午 6:55
 * @DESCRIPTION:
 */
public interface UrlMapper {

    //创建短链接
    public int createShortUrl(Url url);

    //批量创建短链接
    public int createShortUrlList(List<Url> urlList);

    //批量获取短链接信息
    public List<Url> getShortUrlDataList(List<String> shortUrlList);

    //获取短链接信息
    public Url getShortUrlData(String shortUrl);

    //删除短链接
    public int deleteShortUrl(@Param("id")Integer id,@Param("shortUrl") String shortUrl);

    //增加点击次数
    public int addClickCount(Integer id);
}
