package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycComment;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycCommentDao")
public interface CycCommentDao {

	List<CycComment> findList(CycComment bean);

	List<CycComment> findPage(CycComment bean, Integer page, Integer row);

	CycComment save(CycComment bean);

	CycComment update(CycComment bean);

	CycComment findById(CycComment bean);

	CycComment delete(CycComment bean);

	boolean batchSave(List<CycComment> bean);

	boolean batchUpdate(List<CycComment> bean);

	boolean batchDelete(List<CycComment> bean);

}