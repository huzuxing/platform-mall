package com.cyc.platform.common.common;

/**
 * Created by huzuxing on 2017/9/18.
 */
public final class Constant {

    private Constant() {
        throw new UnsupportedOperationException();
    }

    /**客户端请求执行任务的超时时间*/
    public final static int REQUEST_TIMEOUT_MILLISECOND = 30 * 1000;

    /**
     * 分页默认页容量
     */
    public static final Integer DEFAULT_PAGESIZE = 30;
}
