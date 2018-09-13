package com.cyc.platform.common.service;


import com.cyc.platform.common.entity.CycInfoPublicRegion;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycInfoPublicRegionService {

	List<CycInfoPublicRegion> findList(CycInfoPublicRegion bean);

	List<CycInfoPublicRegion> findPage(CycInfoPublicRegion bean, Integer page, Integer row);

	CycInfoPublicRegion add(CycInfoPublicRegion bean);

	CycInfoPublicRegion update(CycInfoPublicRegion bean);

	CycInfoPublicRegion findById(CycInfoPublicRegion bean);

	CycInfoPublicRegion delete(CycInfoPublicRegion bean);

	boolean batchSave(List<CycInfoPublicRegion> bean);

	boolean batchUpdate(List<CycInfoPublicRegion> bean);

	boolean batchDelete(List<CycInfoPublicRegion> bean);

}