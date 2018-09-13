package com.cyc.platform.common.service;


import com.cyc.platform.common.entity.CycInfoClassify;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycInfoClassifyService {

	List<CycInfoClassify> findList(CycInfoClassify bean);

	List<CycInfoClassify> findPage(CycInfoClassify bean, Integer page, Integer row);

	CycInfoClassify add(CycInfoClassify bean);

	CycInfoClassify update(CycInfoClassify bean);

	CycInfoClassify findById(CycInfoClassify bean);

	CycInfoClassify delete(CycInfoClassify bean);

	boolean batchSave(List<CycInfoClassify> bean);

	boolean batchUpdate(List<CycInfoClassify> bean);

	boolean batchDelete(List<CycInfoClassify> bean);

}