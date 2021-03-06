package com.cyc.platform.common.service;


import com.cyc.platform.common.entity.CycInfoContacts;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycInfoContactsService {

	List<CycInfoContacts> findList(CycInfoContacts bean);

	List<CycInfoContacts> findPage(CycInfoContacts bean, Integer page, Integer row);

	CycInfoContacts add(CycInfoContacts bean);

	CycInfoContacts update(CycInfoContacts bean);

	CycInfoContacts findById(CycInfoContacts bean);

	CycInfoContacts delete(CycInfoContacts bean);

	boolean batchSave(List<CycInfoContacts> bean);

	boolean batchUpdate(List<CycInfoContacts> bean);

	boolean batchDelete(List<CycInfoContacts> bean);

}