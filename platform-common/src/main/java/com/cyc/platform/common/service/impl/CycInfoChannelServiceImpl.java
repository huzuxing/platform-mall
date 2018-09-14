package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycInfoChannel;
import com.cyc.platform.common.service.CycInfoChannelService;
import com.cyc.platform.common.dao.CycInfoChannelDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycInfoChannelService")
public class CycInfoChannelServiceImpl implements CycInfoChannelService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycInfoChannel> findList(final CycInfoChannel bean) {

		return cycInfoChannelDao.findList(bean);
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycInfoChannel> findPage(final CycInfoChannel bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	@Transactional
	public CycInfoChannel add(final CycInfoChannel bean) {
		cycInfoChannelDao.save(bean);
		return bean;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	@Transactional
	public CycInfoChannel update(final CycInfoChannel bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycInfoChannel findById(final CycInfoChannel bean) {

		return cycInfoChannelDao.findById(bean);
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	@Transactional
	public CycInfoChannel delete(final CycInfoChannel bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	public boolean batchSave(List<CycInfoChannel> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	public boolean batchUpdate(List<CycInfoChannel> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	public boolean batchDelete(List<CycInfoChannel> bean) {

		return false;
	}
	@Resource
	private CycInfoChannelDao cycInfoChannelDao;

}