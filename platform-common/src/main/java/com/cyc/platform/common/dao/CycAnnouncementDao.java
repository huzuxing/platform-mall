package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycAnnouncement;
import com.cyc.platform.common.sqlprovider.CycAnnouncementProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycAnnouncementDao")
public interface CycAnnouncementDao {

	@SelectProvider(type = CycAnnouncementProvider.class, method = "findList")
	List<CycAnnouncement> findList(CycAnnouncement bean);

	List<CycAnnouncement> findPage(CycAnnouncement bean, Integer page, Integer row);

	@Insert("insert into cyc_announcement(title, content, position_id, time_create) values(#{title}, #{content}, #{positionId},#{timeCreate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int save(CycAnnouncement bean);

	int update(CycAnnouncement bean);

	CycAnnouncement findById(CycAnnouncement bean);

	CycAnnouncement delete(CycAnnouncement bean);

	boolean batchSave(List<CycAnnouncement> bean);

	boolean batchUpdate(List<CycAnnouncement> bean);

	boolean batchDelete(List<CycAnnouncement> bean);

}