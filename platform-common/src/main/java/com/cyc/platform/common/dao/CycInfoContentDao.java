package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycInfoContent;
import com.cyc.platform.common.sqlprovider.CycInfoContentProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycInfoContentDao")
public interface CycInfoContentDao {

	List<CycInfoContent> findList(CycInfoContent bean);

	List<CycInfoContent> findPage(CycInfoContent bean, Integer page, Integer row);

	@InsertProvider(type = CycInfoContentProvider.class,method = "save")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int save(CycInfoContent bean);

	int update(CycInfoContent bean);

	@Select("select * from cyc_info_content where id=#{id}")
	CycInfoContent findById(CycInfoContent bean);

	CycInfoContent delete(CycInfoContent bean);

	boolean batchSave(List<CycInfoContent> bean);

	boolean batchUpdate(List<CycInfoContent> bean);

	boolean batchDelete(List<CycInfoContent> bean);

}