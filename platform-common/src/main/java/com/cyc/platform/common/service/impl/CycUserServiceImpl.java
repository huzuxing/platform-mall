package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycUser;
import com.cyc.platform.common.service.CycUserService;
import com.cyc.platform.common.dao.CycUserDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycUserService")
public class CycUserServiceImpl implements CycUserService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycUser> findList(final CycUser bean) {

		return null;
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycUser> findPage(final CycUser bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	public CycUser add(final CycUser bean) {

		return null;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	public CycUser update(final CycUser bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycUser findById(final CycUser bean) {

		return null;
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	public CycUser delete(final CycUser bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	public boolean batchSave(List<CycUser> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	public boolean batchUpdate(List<CycUser> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	public boolean batchDelete(List<CycUser> bean) {

		return false;
	}
	@Resource
	private CycUserDao cycUserDao;

}