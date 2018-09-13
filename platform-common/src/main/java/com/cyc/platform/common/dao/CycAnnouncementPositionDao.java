package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycAnnouncementPosition;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycAnnuoncementPositionDao")
public interface CycAnnouncementPositionDao {

	@Select("select * from cyc_announcement_position")
	List<CycAnnouncementPosition> findList(CycAnnouncementPosition bean);

	List<CycAnnouncementPosition> findPage(CycAnnouncementPosition bean, Integer page, Integer row);

	@Insert("insert into cyc_announcement_position (name, time_create) values(#{name}, #{timeCreate})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int save(CycAnnouncementPosition bean);

	int update(CycAnnouncementPosition bean);

	@Select("select * from cyc_announcement_position where id=#{id}")
	CycAnnouncementPosition findById(CycAnnouncementPosition bean);

	CycAnnouncementPosition delete(CycAnnouncementPosition bean);

	boolean batchSave(List<CycAnnouncementPosition> bean);

	boolean batchUpdate(List<CycAnnouncementPosition> bean);

	boolean batchDelete(List<CycAnnouncementPosition> bean);

}