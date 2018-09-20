package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycCommentParentchildren;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycCommentParentchildrenDao")
public interface CycCommentParentchildrenDao {

	List<CycCommentParentchildren> findList(CycCommentParentchildren bean);

	List<CycCommentParentchildren> findPage(CycCommentParentchildren bean, Integer page, Integer row);

	@Insert("insert into cyc_comment_parentchildren(parent_id, child_id) values(#{parentId}, #{childId})")
	int save(CycCommentParentchildren bean);

	int update(CycCommentParentchildren bean);

	CycCommentParentchildren findById(CycCommentParentchildren bean);

	CycCommentParentchildren delete(CycCommentParentchildren bean);

	boolean batchSave(List<CycCommentParentchildren> bean);

	boolean batchUpdate(List<CycCommentParentchildren> bean);

	boolean batchDelete(List<CycCommentParentchildren> bean);

}