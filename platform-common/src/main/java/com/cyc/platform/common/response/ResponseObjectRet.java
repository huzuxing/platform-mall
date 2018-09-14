package com.cyc.platform.common.response;

import com.google.gson.annotations.Expose;

/**
 * Created by huzuxing on 2017/8/15.
 */
public class ResponseObjectRet<E> extends RetEntity {
    @Expose()
    private E data;

    public ResponseObjectRet(Integer code, String msg) {
        super(code, msg);
    }

    public ResponseObjectRet(Integer code, String msg, E object) {
        super(code, msg);
        this.data = object;
    }
}
