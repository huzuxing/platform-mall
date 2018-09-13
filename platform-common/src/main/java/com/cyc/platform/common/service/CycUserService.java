package com.cyc.platform.common.service;


import com.cyc.platform.common.entity.CycUser;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycUserService {

	List<CycUser> findList(CycUser bean);

	List<CycUser> findPage(CycUser bean, Integer page, Integer row);

	CycUser add(CycUser bean);

	CycUser update(CycUser bean);

	CycUser findById(CycUser bean);

	CycUser delete(CycUser bean);

	boolean batchSave(List<CycUser> bean);

	boolean batchUpdate(List<CycUser> bean);

	boolean batchDelete(List<CycUser> bean);

}