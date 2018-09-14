package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycInfoStick;
import com.cyc.platform.common.service.CycInfoStickService;
import com.cyc.platform.common.dao.CycInfoStickDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycInfoStickService")
public class CycInfoStickServiceImpl implements CycInfoStickService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycInfoStick> findList(final CycInfoStick bean) {

		return cycInfoStickDao.findList(bean);
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycInfoStick> findPage(final CycInfoStick bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	@Transactional
	public CycInfoStick add(final CycInfoStick bean) {
		cycInfoStickDao.save(bean);
		return bean;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	@Transactional
	public CycInfoStick update(final CycInfoStick bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycInfoStick findById(final CycInfoStick bean) {

		return null;
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	public CycInfoStick delete(final CycInfoStick bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	public boolean batchSave(List<CycInfoStick> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	public boolean batchUpdate(List<CycInfoStick> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	public boolean batchDelete(List<CycInfoStick> bean) {

		return false;
	}
	@Resource
	private CycInfoStickDao cycInfoStickDao;

}