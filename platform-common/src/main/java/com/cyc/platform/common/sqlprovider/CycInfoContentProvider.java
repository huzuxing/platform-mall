package com.cyc.platform.common.sqlprovider;

import com.cyc.platform.common.entity.CycInfoContent;
import com.cyc.platform.common.utils.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

/**
 * Created by huzuxing on 2018/9/13.
 */
public class CycInfoContentProvider {

    public String save(CycInfoContent bean) throws SQLException {
        if (null == bean) {
            throw new SQLException("none data to save { " + "CycInfoContent" + " }");
        }
        return new SQL() {
            {
                INSERT_INTO("cyc_info_content");
                if (!StringUtils.isNullOrEmpty(bean.getTitle())) {
                    VALUES("title", bean.getTitle());
                }
                if (!StringUtils.isNullOrEmpty(bean.getShortTitle())) {
                    VALUES("short_title", bean.getShortTitle());
                }
                if (!StringUtils.isNullOrEmpty(bean.getDescription())) {
                    VALUES("description", bean.getDescription());
                }
                if (!StringUtils.isNullOrEmpty(bean.getContent())) {
                    VALUES("content", "'" + bean.getContent() + "'");
                }
                if (null != bean.getIsSticked()) {
                    VALUES("is_sticked", String.valueOf(bean.getIsSticked()));
                }
                if (null != bean.getTimeCreate()) {
                    VALUES("time_create", String.valueOf(bean.getTimeCreate()));
                }
                if (null != bean.getTimePublish()) {
                    VALUES("time_publish", String.valueOf(bean.getTimePublish()));
                }
            }
        }.toString();
    }
}
