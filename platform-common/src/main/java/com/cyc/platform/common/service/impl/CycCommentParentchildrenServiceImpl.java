package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycCommentParentchildren;
import com.cyc.platform.common.service.CycCommentParentchildrenService;
import com.cyc.platform.common.dao.CycCommentParentchildrenDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycCommentParentchildrenService")
public class CycCommentParentchildrenServiceImpl implements CycCommentParentchildrenService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycCommentParentchildren> findList(final CycCommentParentchildren bean) {

		return null;
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycCommentParentchildren> findPage(final CycCommentParentchildren bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	public CycCommentParentchildren add(final CycCommentParentchildren bean) {

		return null;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	public CycCommentParentchildren update(final CycCommentParentchildren bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycCommentParentchildren findById(final CycCommentParentchildren bean) {

		return null;
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	public CycCommentParentchildren delete(final CycCommentParentchildren bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	public boolean batchSave(List<CycCommentParentchildren> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	public boolean batchUpdate(List<CycCommentParentchildren> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	public boolean batchDelete(List<CycCommentParentchildren> bean) {

		return false;
	}
	@Resource
	private CycCommentParentchildrenDao cycCommentParentchildrenDao;

}