package com.piao.service.impl;

import com.piao.bean.Url;

import com.piao.common.Const;
import com.piao.mapper.UrlMapper;
import com.piao.service.UrlService;
import com.piao.util.ShortUrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @PROJECT_NAME: url-short
 * @USER: Leishen
 * @DATE: 2021/1/8 下午 7:58
 * @DESCRIPTION:
 */
@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    private UrlMapper urlMapper;

    /**
     * @Description: 创建短链接
     * @Author: Piao
     * @Date: 2021/1/10 下午 7:32
     * @param longUrl: 长链接
     * @param inDate: 有效期(天)
     * @return: java.lang.String
     **/
    @Override
    public String createShortUrl(String longUrl,Integer inDate) {
        try {
            Random random = new Random();
            //生成短链接 一个长链接最多可以创建4个短链接
            String shortUrl = ShortUrlUtil.shortUrl(longUrl)[random.nextInt(4)];
            //获取短链接信息
            Url url = urlMapper.getShortUrlData(shortUrl);
            //如果url有数据则从数据库中删除数据
            if(url != null){
                urlMapper.deleteShortUrl(url.getId(), url.getShortUrl());
            }
            //如果url为空则创建url对象
            if(url == null){
                url = new Url();
                //设置长链接
                url.setLongUrl(longUrl);
                //设置短链接
                url.setShortUrl(shortUrl);
            }
            //获取当前时间
            Date date = new Date();
            //设置创建时间
            url.setCreateTime(date);
            if(inDate != null){
                //返回当前13位时间戳
                long timestamp = date.getTime();
                //生成过期毫秒值
                long destroy = inDate * 24 * 60 * 60 * 1000;
                //创建过期时间
                Date destroyTime = new Date(timestamp + destroy);
                //设置过期时间
                url.setDestroyTime(destroyTime);
            }else{
                url.setDestroyTime(null);
            }
            //设置点击次数，默认为0
            url.setClickCount(0);
            //设置状态，1为可用 0为不可用
            url.setStatus(1);
            return urlMapper.createShortUrl(url) > 0 ? url.getShortUrl() : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Description: 批量创建短链接
     * @Author: Piao
     * @Date: 2021/1/12 下午 1:57
     * @param longUrls: 长链接数组
     * @param inDate: 有效期（天）
     * @return: java.util.List<java.lang.String>
     **/
    @Override
    public List<String> createShortUrlList(String[] longUrls, Integer inDate) {
        try {
            Random random = new Random();
            //创建存放url对象的集合
            List<Url> urlList = new ArrayList<>();
            //创建存放短链接的集合
            List<String> shortList = new ArrayList<>();
            //循环遍历longUrls数组
            for (String longUrl : longUrls) {
                //生成短链接 一个长链接最多可以创建4个短链接
                String shortUrl = ShortUrlUtil.shortUrl(longUrl)[random.nextInt(4)];
                //获取短链接信息
                Url url = urlMapper.getShortUrlData(shortUrl);
                //如果url有数据则从数据库中删除数据
                if(url != null){
                    urlMapper.deleteShortUrl(url.getId(), url.getShortUrl());
                }
                //如果url为空则创建url对象
                if(url == null){
                    url = new Url();
                    //设置长链接
                    url.setLongUrl(longUrl);
                    //设置短链接
                    url.setShortUrl(shortUrl);
                }
                //获取当前时间
                Date date = new Date();
                //设置创建时间
                url.setCreateTime(date);
                //如果inDate为null则到期时间为永久有效
                if(inDate != null){
                    //返回当前13位时间戳
                    long timestamp = date.getTime();
                    //生成过期毫秒值
                    long destroy = inDate * 24 * 60 * 60 * 1000;
                    //创建过期时间
                    Date destroyTime = new Date(timestamp + destroy);
                    //设置过期时间
                    url.setDestroyTime(destroyTime);
                }else{
                    url.setDestroyTime(null);
                }
                //设置点击次数，默认为0
                url.setClickCount(0);
                //设置状态，1为可用 0为不可用
                url.setStatus(1);
                //将url对象添加到urlList集合中
                urlList.add(url);
                //将短链接添加到shortList集合中
                shortList.add(Const.HOST + shortUrl);
            }
            int result = urlMapper.createShortUrlList(urlList);
            return result > 0 ? shortList : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Description: 获取长链接
     * @Author: Piao
     * @Date: 2021/1/12 下午 1:56
     * @param shortUrl: 短链接
     * @return: java.lang.String
     **/
    @Override
    public String getLongUrl(String shortUrl) {
        try {
            //获取短链接信息
            Url data = urlMapper.getShortUrlData(shortUrl);
            //如果状态为 0 或 已过期则不可用，返回null
            if(data == null || data.getStatus().intValue() == 0 ||data.getDestroyTime() != null && data.getDestroyTime().compareTo(new Date()) < 0){
                return null;
            }else{
                //调用增加点击次数的方法
                urlMapper.addClickCount(data.getId());
                return data.getLongUrl();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Description: 批量获取短链接数据
     * @Author: Piao
     * @Date: 2021/1/12 下午 11:37
     * @param shortUrls: 短链接地址数组
     * @return: java.util.List<com.piao.bean.Url>
     **/
    @Override
    public List<Url> getShortDataList(String[] shortUrls) {
        try {
            List<String> urlList = new ArrayList<>();
            //判断是否为主机名开头，如果是主机名开头则删除主机名
            for(int i = 0;i<shortUrls.length;i++){
                if(shortUrls[i].startsWith(Const.HOST)){
                    shortUrls[i] = shortUrls[i].substring(Const.HOST.length());
                }
                urlList.add(shortUrls[i]);
            }
            List<Url> shortUrlDataList = urlMapper.getShortUrlDataList(urlList);
            return shortUrlDataList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
