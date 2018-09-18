package com.cyc.platform.common.service;


import com.cyc.platform.common.entity.CycInfoContentExt;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycInfoContentExtService {

	List<CycInfoContentExt> findList(CycInfoContentExt bean);

	List<CycInfoContentExt> findPage(CycInfoContentExt bean, Integer page, Integer row);

	CycInfoContentExt add(CycInfoContentExt bean);

	CycInfoContentExt update(CycInfoContentExt bean);

	CycInfoContentExt findById(CycInfoContentExt bean);

	CycInfoContentExt delete(CycInfoContentExt bean);

	boolean batchSave(List<CycInfoContentExt> bean);

	boolean batchUpdate(List<CycInfoContentExt> bean);

	boolean batchDelete(List<CycInfoContentExt> bean);

	int up(Integer infoId);

	int view(Integer infoId);
}