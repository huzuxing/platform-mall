package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycComment;
import com.cyc.platform.common.service.CycCommentService;
import com.cyc.platform.common.dao.CycCommentDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycCommentService")
public class CycCommentServiceImpl implements CycCommentService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycComment> findList(final CycComment bean) {

		return null;
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycComment> findPage(final CycComment bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	public CycComment add(final CycComment bean) {

		return null;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	public CycComment update(final CycComment bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycComment findById(final CycComment bean) {

		return null;
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	public CycComment delete(final CycComment bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	public boolean batchSave(List<CycComment> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	public boolean batchUpdate(List<CycComment> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	public boolean batchDelete(List<CycComment> bean) {

		return false;
	}
	@Resource
	private CycCommentDao cycCommentDao;

}