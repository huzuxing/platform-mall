package com.cyc.platform.common.sqlprovider;

/**
 * Created by huzuxing on 2018/9/14.
 */
public class BaseProvider {

    protected Integer page(Integer page) {
        return null == page ? 1 : page;
    }

    protected Integer rows(Integer rows) {
        return null == rows ? 10 : rows;
    }
}
