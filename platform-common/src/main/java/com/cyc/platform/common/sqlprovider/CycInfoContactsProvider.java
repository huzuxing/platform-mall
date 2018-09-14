package com.cyc.platform.common.sqlprovider;

import com.cyc.platform.common.entity.CycInfoContacts;
import com.cyc.platform.common.utils.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

/**
 * Created by huzuxing on 2018/9/14.
 */
public class CycInfoContactsProvider {

    public String save(CycInfoContacts bean) throws SQLException {

        if (null == bean) {
            throw new SQLException("none data to save { " + "CycInfoContacts" + " }");
        }

        return new SQL() {
            {
                INSERT_INTO("cyc_info_contacts");

                if (!StringUtils.isNullOrEmpty(bean.getName())) {
                    VALUES("name", "#{name}");
                }
                if (!StringUtils.isNullOrEmpty(bean.getContact())) {
                    VALUES("contact", "#{contact}");
                }
                if (!StringUtils.isNullOrEmpty(bean.getProvince())) {
                    VALUES("province", "#{province}");
                }
                if (!StringUtils.isNullOrEmpty(bean.getCity())) {
                    VALUES("city", "#{city}");
                }
                if (!StringUtils.isNullOrEmpty(bean.getDistrict())) {
                    VALUES("district", "#{district}");
                }
                if (!StringUtils.isNullOrEmpty(bean.getAddress())) {
                    VALUES("address", "#{address}");
                }
                if (null != bean.getTimeCreate()) {
                    VALUES("time_create", "#{timeCreate}");
                }
            }
        }.toString();
    }
}
