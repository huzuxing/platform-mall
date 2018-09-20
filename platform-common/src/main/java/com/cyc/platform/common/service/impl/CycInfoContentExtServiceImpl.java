package com.cyc.platform.common.service.impl;


import com.cyc.platform.common.entity.CycInfoContentExt;
import com.cyc.platform.common.service.CycInfoContentExtService;
import com.cyc.platform.common.dao.CycInfoContentExtDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public CycInfoContentExt add(final CycInfoContentExt bean) {
		cycInfoContentExtDao.save(bean);
		return bean;
	}
	/**
 	 * 更新数据 
 	**/
	@Override
	@Transactional
	public CycInfoContentExt update(final CycInfoContentExt bean) {
		cycInfoContentExtDao.update(bean);
		return bean;
	}
	/**
 	 * 根据ID获取数据，需要参数校验 
 	**/
	@Override
	public CycInfoContentExt findById(final CycInfoContentExt bean) {

		return cycInfoContentExtDao.findById(bean);
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

	/**
	 * 点赞
	 * @param infoId
	 * @return
     */
	@Override
	public int up(Integer infoId) {
		CycInfoContentExt bean = new CycInfoContentExt();
		bean.setInfoId(infoId);
		CycInfoContentExt entity = cycInfoContentExtDao.findById(bean);
		int count = 0;
		if (null == entity) {
			count = 1;
			bean.setPraiseCount(count);
			cycInfoContentExtDao.save(bean);
			return count;
		}
		count = entity.getPraiseCount() + 1;
		bean.setPraiseCount(count);
		cycInfoContentExtDao.update(bean);
		return count;
	}

	/**
	 * 查看
	 * @param infoId
	 * @return
     */
	@Override
	public int view(Integer infoId) {
		CycInfoContentExt bean = new CycInfoContentExt();
		bean.setInfoId(infoId);
		CycInfoContentExt entity = cycInfoContentExtDao.findById(bean);
		int count = 0;
		if (null == entity) {
			count = 1;
			bean.setViewCount(count);
			cycInfoContentExtDao.save(bean);
			return count;
		}
		count = entity.getViewCount() + 1;
		bean.setViewCount(count);
		cycInfoContentExtDao.update(bean);
		return count;
	}

	@Resource
	private CycInfoContentExtDao cycInfoContentExtDao;

}