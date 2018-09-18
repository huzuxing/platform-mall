package com.cyc.platform.common.sqlprovider;

import com.cyc.platform.common.entity.CycInfoContentExt;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

/**
 * Created by huzuxing on 2018/9/18.
 */
public class CycInfoContentExtProvider {

    public String update(CycInfoContentExt bean) throws SQLException {
        if (null == bean || null == bean.getInfoId()) {
            throw new SQLException("could not find entity { " + "CycInfoContacts" + " } with no infoId");
        }

        return new SQL() {
            {
                UPDATE("cyc_info_content_ext");
                if (null != bean.getPraiseCount()) {
                    SET("praise_count=#{praiseCount}");
                }
                if (null != bean.getViewCount()) {
                    SET("view_count=#{viewCount}");
                }
                WHERE("info_id=#{infoId}");
            }
        }.toString();

    }
}
