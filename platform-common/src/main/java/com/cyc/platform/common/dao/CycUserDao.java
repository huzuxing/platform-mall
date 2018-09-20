package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycUser;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycUserDao")
public interface CycUserDao {

	List<CycUser> findList(CycUser bean);

	List<CycUser> findPage(CycUser bean, Integer page, Integer row);

	int save(CycUser bean);

	int update(CycUser bean);

	CycUser findById(CycUser bean);

	CycUser delete(CycUser bean);

	boolean batchSave(List<CycUser> bean);

	boolean batchUpdate(List<CycUser> bean);

	boolean batchDelete(List<CycUser> bean);

}