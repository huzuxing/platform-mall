package com.cyc.platform.common.sqlprovider;

import com.cyc.platform.common.entity.CycAnnouncement;
import org.apache.ibatis.jdbc.SQL;
import org.aspectj.weaver.ast.And;

/**
 * Created by huzuxing on 2018/9/13.
 */
public class CycAnnouncementProvider {

    public String findList(CycAnnouncement bean) {

        return new SQL() {
            {
                SELECT("*");
                FROM("cyc_announcement o");
                WHERE("1=1");
                if (null != bean) {
                    if (null != bean.getPositionId()) {
                        AND().WHERE("position_id=#{positionId}");
                    }
                }
            }
        }.toString();
    }
}
