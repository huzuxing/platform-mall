package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycInfoClassify;
import com.cyc.platform.common.sqlprovider.CycInfoClassifyProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycInfoClassifyDao {

	List<CycInfoClassify> findList(CycInfoClassify bean);

	List<CycInfoClassify> findPage(CycInfoClassify bean, Integer page, Integer row);

	@Insert("insert into cyc_info_classify(name, parent_id,sort, time_create) values(#{name}, #{parentId}, #{sort}, #{timeCreate})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int save(CycInfoClassify bean);

	@UpdateProvider(type = CycInfoClassifyProvider.class, method = "update")
	int update(CycInfoClassify bean);

	@Select("select * from cyc_info_classify where id=#{id}")
	CycInfoClassify findById(CycInfoClassify bean);

	CycInfoClassify delete(CycInfoClassify bean);

	boolean batchSave(List<CycInfoClassify> bean);

	boolean batchUpdate(List<CycInfoClassify> bean);

	boolean batchDelete(List<CycInfoClassify> bean);

}