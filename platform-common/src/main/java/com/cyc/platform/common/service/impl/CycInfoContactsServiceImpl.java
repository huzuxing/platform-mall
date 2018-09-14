package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycInfoContacts;
import com.cyc.platform.common.service.CycInfoContactsService;
import com.cyc.platform.common.dao.CycInfoContactsDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycInfoContactsService")
public class CycInfoContactsServiceImpl implements CycInfoContactsService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycInfoContacts> findList(final CycInfoContacts bean) {

		return null;
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycInfoContacts> findPage(final CycInfoContacts bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	@Transactional
	public CycInfoContacts add(final CycInfoContacts bean) {
		cycInfoContactsDao.save(bean);
		return bean;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	@Transactional
	public CycInfoContacts update(final CycInfoContacts bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycInfoContacts findById(final CycInfoContacts bean) {

		return cycInfoContactsDao.findById(bean);
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	public CycInfoContacts delete(final CycInfoContacts bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	public boolean batchSave(List<CycInfoContacts> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	public boolean batchUpdate(List<CycInfoContacts> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	public boolean batchDelete(List<CycInfoContacts> bean) {

		return false;
	}
	@Resource
	private CycInfoContactsDao cycInfoContactsDao;

}