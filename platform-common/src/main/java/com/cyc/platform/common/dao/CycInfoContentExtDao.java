package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycInfoContentExt;
import com.cyc.platform.common.sqlprovider.CycInfoContentExtProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycInfoContentExtDao")
public interface CycInfoContentExtDao {

	List<CycInfoContentExt> findList(CycInfoContentExt bean);

	List<CycInfoContentExt> findPage(CycInfoContentExt bean, Integer page, Integer row);

	@Insert("insert into cyc_info_content_ext(info_id, view_count, praise_count, forward_count, collect_count) values(#{infoId}, #{viewCount}, #{praiseCount}, #{forwardCount}, #{collectCount})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int save(CycInfoContentExt bean);

	@UpdateProvider(type = CycInfoContentExtProvider.class, method = "update")
	int update(CycInfoContentExt bean);

	@Select("select * from cyc_info_content_ext where info_id=#{infoId}")
	CycInfoContentExt findById(CycInfoContentExt bean);

	CycInfoContentExt delete(CycInfoContentExt bean);

	boolean batchSave(List<CycInfoContentExt> bean);

	boolean batchUpdate(List<CycInfoContentExt> bean);

	boolean batchDelete(List<CycInfoContentExt> bean);

}