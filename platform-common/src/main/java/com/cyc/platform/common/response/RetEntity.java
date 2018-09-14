package com.cyc.platform.common.response;

import com.google.gson.annotations.Expose;

/**
 * Created by huzuxing on 2017/8/15.
 */
public class RetEntity implements java.io.Serializable{

    @Expose()
    private Integer code;
    @Expose()
    private String msg;

    public RetEntity(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
