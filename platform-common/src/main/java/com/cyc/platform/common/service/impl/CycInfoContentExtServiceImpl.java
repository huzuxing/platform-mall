package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycInfoContentExt;
import com.cyc.platform.common.service.CycInfoContentExtService;
import com.cyc.platform.common.dao.CycInfoContentExtDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycInfoContentExtService")
public class CycInfoContentExtServiceImpl implements CycInfoContentExtService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycInfoContentExt> findList(final CycInfoContentExt bean) {

		return null;
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycInfoContentExt> findPage(final CycInfoContentExt bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	public CycInfoContentExt add(final CycInfoContentExt bean) {
		cycInfoContentExtDao.save(bean);
		return bean;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	public CycInfoContentExt update(final CycInfoContentExt bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycInfoContentExt findById(final CycInfoContentExt bean) {

		return null;
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	public CycInfoContentExt delete(final CycInfoContentExt bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	public boolean batchSave(List<CycInfoContentExt> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	public boolean batchUpdate(List<CycInfoContentExt> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	public boolean batchDelete(List<CycInfoContentExt> bean) {

		return false;
	}
	@Resource
	private CycInfoContentExtDao cycInfoContentExtDao;

}