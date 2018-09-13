package com.cyc.platform.common.service;


import com.cyc.platform.common.entity.CycAnnouncementPosition;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycAnnouncementPositionService {

	List<CycAnnouncementPosition> findList(CycAnnouncementPosition bean);

	List<CycAnnouncementPosition> findPage(CycAnnouncementPosition bean, Integer page, Integer row);

	CycAnnouncementPosition add(CycAnnouncementPosition bean);

	CycAnnouncementPosition update(CycAnnouncementPosition bean);

	CycAnnouncementPosition findById(CycAnnouncementPosition bean);

	CycAnnouncementPosition delete(CycAnnouncementPosition bean);

	boolean batchSave(List<CycAnnouncementPosition> bean);

	boolean batchUpdate(List<CycAnnouncementPosition> bean);

	boolean batchDelete(List<CycAnnouncementPosition> bean);

}