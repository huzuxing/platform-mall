package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycInfoPublicRegion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycInfoPublicRegionDao")
public interface CycInfoPublicRegionDao {

	@Select("select * from cyc_info_public_region")
	List<CycInfoPublicRegion> findList(CycInfoPublicRegion bean);

	List<CycInfoPublicRegion> findPage(CycInfoPublicRegion bean, Integer page, Integer row);

	@Insert("insert into cyc_info_public_region(name,sort, fee, time_create) values(#{name}, #{sort}, #{fee}, #{timeCreate})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int save(CycInfoPublicRegion bean);

	int update(CycInfoPublicRegion bean);

	@Select("select * from cyc_info_public_region where id=#{id}")
	CycInfoPublicRegion findById(CycInfoPublicRegion bean);

	CycInfoPublicRegion delete(CycInfoPublicRegion bean);

	boolean batchSave(List<CycInfoPublicRegion> bean);

	boolean batchUpdate(List<CycInfoPublicRegion> bean);

	boolean batchDelete(List<CycInfoPublicRegion> bean);

}