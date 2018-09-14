package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycInfoContentExt;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycInfoContentExtDao")
public interface CycInfoContentExtDao {

	List<CycInfoContentExt> findList(CycInfoContentExt bean);

	List<CycInfoContentExt> findPage(CycInfoContentExt bean, Integer page, Integer row);

	CycInfoContentExt save(CycInfoContentExt bean);

	CycInfoContentExt update(CycInfoContentExt bean);

	CycInfoContentExt findById(CycInfoContentExt bean);

	CycInfoContentExt delete(CycInfoContentExt bean);

	boolean batchSave(List<CycInfoContentExt> bean);

	boolean batchUpdate(List<CycInfoContentExt> bean);

	boolean batchDelete(List<CycInfoContentExt> bean);

}