package com.cyc.platform.common.service;


import com.cyc.platform.common.entity.CycInfoChannel;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycInfoChannelService {

	List<CycInfoChannel> findList(CycInfoChannel bean);

	List<CycInfoChannel> findPage(CycInfoChannel bean, Integer page, Integer row);

	CycInfoChannel add(CycInfoChannel bean);

	CycInfoChannel update(CycInfoChannel bean);

	CycInfoChannel findById(CycInfoChannel bean);

	CycInfoChannel delete(CycInfoChannel bean);

	boolean batchSave(List<CycInfoChannel> bean);

	boolean batchUpdate(List<CycInfoChannel> bean);

	boolean batchDelete(List<CycInfoChannel> bean);

}