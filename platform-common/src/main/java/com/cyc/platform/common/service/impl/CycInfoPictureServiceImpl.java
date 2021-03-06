package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycInfoPicture;
import com.cyc.platform.common.service.CycInfoPictureService;
import com.cyc.platform.common.dao.CycInfoPictureDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycInfoPictureService")
public class CycInfoPictureServiceImpl implements CycInfoPictureService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycInfoPicture> findList(final CycInfoPicture bean) {

		return null;
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycInfoPicture> findPage(final CycInfoPicture bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	public CycInfoPicture add(final CycInfoPicture bean) {

		return null;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	public CycInfoPicture update(final CycInfoPicture bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycInfoPicture findById(final CycInfoPicture bean) {

		return null;
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	public CycInfoPicture delete(final CycInfoPicture bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	public boolean batchSave(List<CycInfoPicture> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	public boolean batchUpdate(List<CycInfoPicture> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	public boolean batchDelete(List<CycInfoPicture> bean) {

		return false;
	}
	@Resource
	private CycInfoPictureDao cycInfoPictureDao;

}