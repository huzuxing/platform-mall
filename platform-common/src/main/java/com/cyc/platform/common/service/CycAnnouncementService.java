package com.cyc.platform.common.service;


import com.cyc.platform.common.entity.CycAnnouncement;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycAnnouncementService {

	List<CycAnnouncement> findList(CycAnnouncement bean);

	List<CycAnnouncement> findPage(CycAnnouncement bean, Integer page, Integer row);

	CycAnnouncement add(CycAnnouncement bean);

	CycAnnouncement update(CycAnnouncement bean);

	CycAnnouncement findById(CycAnnouncement bean);

	CycAnnouncement delete(CycAnnouncement bean);

	boolean batchSave(List<CycAnnouncement> bean);

	boolean batchUpdate(List<CycAnnouncement> bean);

	boolean batchDelete(List<CycAnnouncement> bean);

}