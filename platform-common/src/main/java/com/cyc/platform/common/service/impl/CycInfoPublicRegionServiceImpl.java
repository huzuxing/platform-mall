package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycInfoPublicRegion;
import com.cyc.platform.common.service.CycInfoPublicRegionService;
import com.cyc.platform.common.dao.CycInfoPublicRegionDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycInfoPublicRegionService")
public class CycInfoPublicRegionServiceImpl implements CycInfoPublicRegionService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycInfoPublicRegion> findList(final CycInfoPublicRegion bean) {

		return cycInfoPublicRegionDao.findList(bean);
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycInfoPublicRegion> findPage(final CycInfoPublicRegion bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	@Transactional
	public CycInfoPublicRegion add(final CycInfoPublicRegion bean) {
		cycInfoPublicRegionDao.save(bean);
		return bean;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	@Transactional
	public CycInfoPublicRegion update(final CycInfoPublicRegion bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycInfoPublicRegion findById(final CycInfoPublicRegion bean) {

		return null;
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	public CycInfoPublicRegion delete(final CycInfoPublicRegion bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	public boolean batchSave(List<CycInfoPublicRegion> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	public boolean batchUpdate(List<CycInfoPublicRegion> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	public boolean batchDelete(List<CycInfoPublicRegion> bean) {

		return false;
	}
	@Resource
	private CycInfoPublicRegionDao cycInfoPublicRegionDao;

}