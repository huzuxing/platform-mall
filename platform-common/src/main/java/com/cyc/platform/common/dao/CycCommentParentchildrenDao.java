package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycCommentParentchildren;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycCommentParentchildrenDao {

	List<CycCommentParentchildren> findList(CycCommentParentchildren bean);

	List<CycCommentParentchildren> findPage(CycCommentParentchildren bean, Integer page, Integer row);

	CycCommentParentchildren save(CycCommentParentchildren bean);

	CycCommentParentchildren update(CycCommentParentchildren bean);

	CycCommentParentchildren findById(CycCommentParentchildren bean);

	CycCommentParentchildren delete(CycCommentParentchildren bean);

	boolean batchSave(List<CycCommentParentchildren> bean);

	boolean batchUpdate(List<CycCommentParentchildren> bean);

	boolean batchDelete(List<CycCommentParentchildren> bean);

}