package com.cyc.platform.common.service;


import com.cyc.platform.common.entity.CycInfoContent;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycInfoContentService {

	List<CycInfoContent> findList(CycInfoContent bean);

	List<CycInfoContent> findPage(CycInfoContent bean, Integer page, Integer row);

	CycInfoContent add(CycInfoContent bean);

	CycInfoContent update(CycInfoContent bean);

	CycInfoContent findById(CycInfoContent bean);

	CycInfoContent delete(CycInfoContent bean);

	boolean batchSave(List<CycInfoContent> bean);

	boolean batchUpdate(List<CycInfoContent> bean);

	boolean batchDelete(List<CycInfoContent> bean);

}