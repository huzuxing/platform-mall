package com.cyc.platform.common.common;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by huzuxing on 2017/8/11.
 */
public class Finder {

    private static final Logger logger = LoggerFactory.getLogger(Finder.class);

    private String query;

    private final StringBuilder builder = new StringBuilder();

    private Session session;

    private Integer pageNo;

    private Integer pageSize;

    private final Map<String, Object> params = new HashMap<>();

    @SuppressWarnings("rawtypes")
    private final Map<String, Collection> listParams = new HashMap<>();

    @SuppressWarnings("rawtypes")
    private Class entity;

    // 默认HQL查询
    private boolean isHql = true;

    public Finder() {
    }

    public Finder(String query) {
        this.query = query;
        builder.append(query);
    }

    public Finder(String query, final Session session) {
        this.query = query;
        this.session = session;
        builder.append(query);
    }

    public Finder(String query, final Session session, int pageNo, int pageSize) {
        this.query = query;
        this.session = session;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        builder.append(query);
    }

    public Finder append(String statement) {
        builder.append(statement);
        return this;
    }

    public Finder append(int statement) {
        builder.append(statement);
        return this;
    }

    public void setParameter(String key, Object value) {
        params.put(key, value);
    }

    @SuppressWarnings("rawtypes")
    public void setParameterList(String key, Collection value) {
        listParams.put(key, value);
    }

    // 返回sql语句
    public NativeQuery getSQLQuery() throws IllegalArgumentException {
        NativeQuery sql = null;
        if (null == session)
            throw new IllegalArgumentException("session is not defined ...");
        if (builder.length() > 0) {
            sql = session.createNativeQuery(builder.toString());
            setParams(sql);
        }
        if (null != getEntity() && null != sql) {
            sql.addEntity(getEntity());
        }
        return sql;
    }

    //参数设置
    private void setParams(Query query) {
        Set<String> keys = params.keySet();
        if (keys.size() > 0) {
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                String key = it.next();
                query.setParameter(key, params.get(key));
            }
        }
        Set<String> listKeys = listParams.keySet();
        if (listKeys.size() > 0) {
            Iterator<String> list = listKeys.iterator();
            while (list.hasNext()) {
                String key = list.next();
                query.setParameterList(key, listParams.get(key));
            }
        }
        pageNo = null == pageNo ? 1 : pageNo;
        pageSize = null == pageSize ? 1000 : pageSize;
        query.setFirstResult((pageNo - 1) * pageSize);
        query.setMaxResults(pageSize);
    }

    //返回hql语句
    public Query getQueryHQL() throws IllegalArgumentException {
        Query query = null;
        if (null == session)
            throw new IllegalArgumentException("session is not defined ...");
        if (builder.length() > 0) {
            query = session.createQuery(builder.toString());
            setParams(query);
        }
        return query;
    }

    //获取查询器
    public Query loadQuery() throws IllegalArgumentException {
        Query query = null;
        if (isHql) {
            query = getQueryHQL();
        } else {
            query = getSQLQuery();
        }
        return query;
    }

    // 查询单条数据
    public Object uniqueResult() throws IllegalArgumentException {
        Query query = loadQuery();
        if (null == query) {
            return new Object();
        }
        return query.uniqueResult();
    }

    // 获取结果列表集
    @SuppressWarnings({"rawtypes"})
    public List list() throws IllegalArgumentException {
        Query query = loadQuery();
        if (null == query) {
            return new ArrayList<>();
        }
        List list = null;
        try {
            list = query.list();
        } catch (IllegalArgumentException e) {
            logger.error("", e);
            list = new ArrayList();
        }
        return list;
    }

    // 执行增加或者删除或者更新

    public int executeUpdate() throws IllegalArgumentException {
        return loadQuery().executeUpdate();
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public StringBuilder getBuilder() {
        return builder;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(final Session session) {
        this.session = session;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @SuppressWarnings("rawtypes")
    public Class getEntity() {
        return entity;
    }

    @SuppressWarnings("rawtypes")
    public void setEntity(Class entity) {
        this.entity = entity;
    }

    public boolean isHql() {
        return isHql;
    }

    public void setHql(boolean isHql) {
        this.isHql = isHql;
    }
}
