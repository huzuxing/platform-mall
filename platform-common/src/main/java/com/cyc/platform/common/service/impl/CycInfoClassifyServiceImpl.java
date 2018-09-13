package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycInfoClassify;
import com.cyc.platform.common.service.CycInfoClassifyService;
import com.cyc.platform.common.dao.CycInfoClassifyDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

@Service("cycInfoClassifyService")
public class CycInfoClassifyServiceImpl implements CycInfoClassifyService {

	/**
 	 * 根据条件获取list列表信息 
 	**/
	@Override
	public List<CycInfoClassify> findList(final CycInfoClassify bean) {

		return null;
	}
	/**
 	 * 根据条件获取分页数据 
 	**/
	@Override
	public List<CycInfoClassify> findPage(final CycInfoClassify bean, Integer page, Integer rows) {

		return null;
	}
	/**
 	 * 新增数据接口 
 	**/
	@Override
	public CycInfoClassify add(final CycInfoClassify bean) {

		return null;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	public CycInfoClassify update(final CycInfoClassify bean) {

		return null;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycInfoClassify findById(final CycInfoClassify bean) {

		return null;
	}
	/**
 	 * 根据条件删除数据 
 	**/
	@Override
	public CycInfoClassify delete(final CycInfoClassify bean) {

		return null;
	}
	/**
 	 * 批量保存 
 	**/
	@Override
	public boolean batchSave(List<CycInfoClassify> bean) {

		return false;
	}
	/**
 	 * 批量更新 
 	**/
	@Override
	public boolean batchUpdate(List<CycInfoClassify> bean) {

		return false;
	}
	/**
 	 * 批量删除 
 	**/
	@Override
	public boolean batchDelete(List<CycInfoClassify> bean) {

		return false;
	}
	@Resource
	private CycInfoClassifyDao cycInfoClassifyDao;

}