package com.cyc.platform.common.sqlprovider;

import com.cyc.platform.common.entity.CycInfoChannel;
import com.cyc.platform.common.utils.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

/**
 * Created by huzuxing on 2018/9/13.
 */
public class CycInfoChannelProvider {

    public String update(CycInfoChannel bean) throws SQLException {
        if (null == bean) {
            throw new SQLException("none data to update { " + "CycInfoChannel" + " }");
        }

        return new SQL(){
            {
                UPDATE("cyc_info_channel");
                if (null != bean.getParentId()) {
                    SET("parent_id=#{parentId}");
                }
                if (!StringUtils.isNullOrEmpty(bean.getName())) {
                    SET("name=#{name}");
                }
                if (null != bean.getTimeUpdate()) {
                    SET("time_update=#{timeUpdate}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
