package com.piao.common;

/**
 * @PROJECT_NAME: url-short
 * @USER: Leishen
 * @DATE: 2021/1/10 下午 5:22
 * @DESCRIPTION:
 */
public class CommonResult<T> {
    private Boolean flag;
    private String msg;
    private T data;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CommonResult(Boolean flag, String msg, T data) {

        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public CommonResult(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public CommonResult() {

    }
}
