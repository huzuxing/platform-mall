package com.cyc.platform.common.response;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by huzuxing on 2017/8/15.
 */
public class ResponseListRet<E> extends RetEntity {
    @Expose()
    private Integer total;
    @Expose()
    private Integer page;
    @Expose()
    private Integer rows;
    @Expose()
    private List<E> data;

    public ResponseListRet(Integer code, String msg) {
        super(code, msg);
    }

    public ResponseListRet(Integer code, String msg, List<E> list) {
        super(code, msg);
        this.setData(list);
    }

    public ResponseListRet(Integer code, String msg, Integer total, Integer page, Integer rows, List<E> data) {
        super(code, msg);
        this.total = total;
        this.page = page;
        this.rows = rows;
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }
}
