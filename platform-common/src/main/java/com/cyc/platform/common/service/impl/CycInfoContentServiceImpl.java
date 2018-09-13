package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycInfoContent;
import com.cyc.platform.common.service.CycInfoContentService;
import com.cyc.platform.common.dao.CycInfoContentDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycInfoContentService")
public class CycInfoContentServiceImpl implements CycInfoContentService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycInfoContent> findList(final CycInfoContent bean) {

		return null;
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycInfoContent> findPage(final CycInfoContent bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	@Transactional
	public CycInfoContent add(final CycInfoContent bean) {
		cycInfoContentDao.save(bean);
		return bean;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	public CycInfoContent update(final CycInfoContent bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycInfoContent findById(final CycInfoContent bean) {

		return cycInfoContentDao.findById(bean);
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	public CycInfoContent delete(final CycInfoContent bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	public boolean batchSave(List<CycInfoContent> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	public boolean batchUpdate(List<CycInfoContent> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	public boolean batchDelete(List<CycInfoContent> bean) {

		return false;
	}
	@Resource
	private CycInfoContentDao cycInfoContentDao;

}