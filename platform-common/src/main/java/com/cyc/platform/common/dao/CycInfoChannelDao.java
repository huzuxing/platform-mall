package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycInfoChannel;
import com.cyc.platform.common.sqlprovider.CycInfoChannelProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycInfoClassifyDao")
public interface CycInfoChannelDao {

	@Select("select * from cyc_info_channel")
	List<CycInfoChannel> findList(CycInfoChannel bean);

	List<CycInfoChannel> findPage(CycInfoChannel bean, Integer page, Integer row);

	@Insert("insert into cyc_info_channel(name,icon, parent_id,sort, time_create) values(#{name},#{icon}, #{parentId}, #{sort}, #{timeCreate})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int save(CycInfoChannel bean);

	@UpdateProvider(type = CycInfoChannelProvider.class, method = "update")
	int update(CycInfoChannel bean);

	@Select("select * from cyc_info_channel where id=#{id}")
    CycInfoChannel findById(CycInfoChannel bean);

	CycInfoChannel delete(CycInfoChannel bean);

	boolean batchSave(List<CycInfoChannel> bean);

	boolean batchUpdate(List<CycInfoChannel> bean);

	boolean batchDelete(List<CycInfoChannel> bean);

}