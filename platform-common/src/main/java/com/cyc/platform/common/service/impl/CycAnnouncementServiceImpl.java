package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycAnnouncement;
import com.cyc.platform.common.service.CycAnnouncementService;
import com.cyc.platform.common.dao.CycAnnouncementDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycAnnuoncementService")
public class CycAnnouncementServiceImpl implements CycAnnouncementService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycAnnouncement> findList(final CycAnnouncement bean) {

		return cycAnnuoncementDao.findList(bean);
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycAnnouncement> findPage(final CycAnnouncement bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	@Transactional
	public CycAnnouncement add(final CycAnnouncement bean) {
		cycAnnuoncementDao.save(bean);
		return bean;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	@Transactional
	public CycAnnouncement update(final CycAnnouncement bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycAnnouncement findById(final CycAnnouncement bean) {

		return null;
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	@Transactional
	public CycAnnouncement delete(final CycAnnouncement bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	public boolean batchSave(List<CycAnnouncement> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	public boolean batchUpdate(List<CycAnnouncement> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	public boolean batchDelete(List<CycAnnouncement> bean) {

		return false;
	}
	@Resource
	private CycAnnouncementDao cycAnnuoncementDao;

}