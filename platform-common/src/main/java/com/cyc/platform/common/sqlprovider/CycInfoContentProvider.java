package com.cyc.platform.common.sqlprovider;

import com.cyc.platform.common.entity.CycInfoContent;
import com.cyc.platform.common.utils.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

/**
 * Created by huzuxing on 2018/9/13.
 */
public class CycInfoContentProvider extends BaseProvider{

    public String save(CycInfoContent bean) throws SQLException {
        if (null == bean) {
            throw new SQLException("none data to save { " + "CycInfoContent" + " }");
        }
        return new SQL() {
            {
                INSERT_INTO("cyc_info_content");
                if (!StringUtils.isNullOrEmpty(bean.getTitle())) {
                    VALUES("title", "#{title}");
                }
                if (!StringUtils.isNullOrEmpty(bean.getShortTitle())) {
                    VALUES("short_title", "#{shortTitle}");
                }
                if (!StringUtils.isNullOrEmpty(bean.getDescription())) {
                    VALUES("description", "#{description}");
                }
                if (!StringUtils.isNullOrEmpty(bean.getContent())) {
                    VALUES("content", "#{content}");
                }
                if (null != bean.getIsSticked()) {
                    VALUES("is_sticked", "#{isSticked}");
                }
                if (null != bean.getTimeCreate()) {
                    VALUES("time_create", "#{timeCreate}");
                }
                if (null != bean.getTimePublish()) {
                    VALUES("time_publish", "#{timePublish}");
                }
                if (null != bean.getContactId()) {
                    VALUES("contact_id", "#{contactId}");
                }
                if (null != bean.getChannelId()) {
                    VALUES("channel_id", "#{channelId}");
                }
            }
        }.toString();
    }

    public String findPage(CycInfoContent bean, Integer page, Integer rows) {

        page = page(page);
        rows = rows(rows);

        StringBuilder builder = new StringBuilder("select * from cyc_info_content o where 1=1");

        builder.append(" limit ").append((page - 1) * rows).append(",").append(rows);
        return builder.toString();
    }
}
