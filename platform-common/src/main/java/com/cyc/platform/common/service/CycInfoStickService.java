package com.cyc.platform.common.service;


import com.cyc.platform.common.entity.CycInfoStick;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycInfoStickService {

	List<CycInfoStick> findList(CycInfoStick bean);

	List<CycInfoStick> findPage(CycInfoStick bean, Integer page, Integer row);

	CycInfoStick add(CycInfoStick bean);

	CycInfoStick update(CycInfoStick bean);

	CycInfoStick findById(CycInfoStick bean);

	CycInfoStick delete(CycInfoStick bean);

	boolean batchSave(List<CycInfoStick> bean);

	boolean batchUpdate(List<CycInfoStick> bean);

	boolean batchDelete(List<CycInfoStick> bean);

}