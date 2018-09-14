package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycAnnouncementPosition;
import com.cyc.platform.common.service.CycAnnouncementPositionService;
import com.cyc.platform.common.dao.CycAnnouncementPositionDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycAnnouncementPositionService")
public class CycAnnouncementPositionServiceImpl implements CycAnnouncementPositionService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycAnnouncementPosition> findList(final CycAnnouncementPosition bean) {

		return cycAnnuoncementPositionDao.findList(bean);
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycAnnouncementPosition> findPage(final CycAnnouncementPosition bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	@Transactional
	public CycAnnouncementPosition add(final CycAnnouncementPosition bean) {
		cycAnnuoncementPositionDao.save(bean);
		return bean;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	@Transactional
	public CycAnnouncementPosition update(final CycAnnouncementPosition bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycAnnouncementPosition findById(final CycAnnouncementPosition bean) {

		return cycAnnuoncementPositionDao.findById(bean);
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	@Transactional
	public CycAnnouncementPosition delete(final CycAnnouncementPosition bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	@Transactional
	public boolean batchSave(List<CycAnnouncementPosition> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	@Transactional
	public boolean batchUpdate(List<CycAnnouncementPosition> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	@Transactional
	public boolean batchDelete(List<CycAnnouncementPosition> bean) {

		return false;
	}
	@Resource
	private CycAnnouncementPositionDao cycAnnuoncementPositionDao;

}