package com.piao.bean;

import java.util.Date;

/**
 * @PROJECT_NAME: url-short
 * @USER: Leishen
 * @DATE: 2021/1/10 下午 6:57
 * @DESCRIPTION:
 */
public class Url {
    private Integer id;
    private String longUrl;//长链接
    private String shortUrl;//短链接
    private Date createTime;//创建时间
    private Date destroyTime;//过期时间
    private Integer clickCount;//点击次数
    private Integer status;//状态 1=可用 0表示不可用

    public Url() {
    }

    public Url(Integer id, String longUrl, String shortUrl, Date createTime, Date destroyTime, Integer clickCount, Integer status) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.createTime = createTime;
        this.destroyTime = destroyTime;
        this.clickCount = clickCount;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDestroyTime() {
        return destroyTime;
    }

    public void setDestroyTime(Date destroyTime) {
        this.destroyTime = destroyTime;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
