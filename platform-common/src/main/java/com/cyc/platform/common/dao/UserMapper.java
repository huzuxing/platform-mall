package com.cyc.platform.common.dao;

import com.cyc.platform.common.entity.User;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by huzuxing on 2018/9/12.
 */
public interface UserMapper {
    @Insert("insert into t_user(username,age) values(#{userName,jdbcType=VARCHAR},#{age,jdbcType=NUMERIC})")
    int save(User bean);
}
