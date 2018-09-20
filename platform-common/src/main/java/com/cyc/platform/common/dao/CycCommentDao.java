package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycComment;
import com.cyc.platform.common.sqlprovider.CycCommentProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycCommentDao")
public interface CycCommentDao {

	List<CycComment> findList(CycComment bean);

	List<CycComment> findPage(CycComment bean, Integer page, Integer row);

	@InsertProvider(type = CycCommentProvider.class, method = "save")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int save(CycComment bean);

	int update(CycComment bean);

	@Select("select * from cyc_comment where id=#{id}")
	CycComment findById(CycComment bean);

	CycComment delete(CycComment bean);

	boolean batchSave(List<CycComment> bean);

	boolean batchUpdate(List<CycComment> bean);

	boolean batchDelete(List<CycComment> bean);

}