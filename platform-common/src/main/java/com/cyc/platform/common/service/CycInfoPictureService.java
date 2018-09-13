package com.cyc.platform.common.service;


import com.cyc.platform.common.entity.CycInfoPicture;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycInfoPictureService {

	List<CycInfoPicture> findList(CycInfoPicture bean);

	List<CycInfoPicture> findPage(CycInfoPicture bean, Integer page, Integer row);

	CycInfoPicture add(CycInfoPicture bean);

	CycInfoPicture update(CycInfoPicture bean);

	CycInfoPicture findById(CycInfoPicture bean);

	CycInfoPicture delete(CycInfoPicture bean);

	boolean batchSave(List<CycInfoPicture> bean);

	boolean batchUpdate(List<CycInfoPicture> bean);

	boolean batchDelete(List<CycInfoPicture> bean);

}