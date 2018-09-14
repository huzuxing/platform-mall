package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycInfoContacts;
import com.cyc.platform.common.sqlprovider.CycInfoContactsProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycInfoContactsDao")
public interface CycInfoContactsDao {

	List<CycInfoContacts> findList(CycInfoContacts bean);

	List<CycInfoContacts> findPage(CycInfoContacts bean, Integer page, Integer row);

	@InsertProvider(type = CycInfoContactsProvider.class, method = "save")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int save(CycInfoContacts bean);

	int update(CycInfoContacts bean);

	@Select("select * from cyc_info_contacts where id=#{id}")
	CycInfoContacts findById(CycInfoContacts bean);

	CycInfoContacts delete(CycInfoContacts bean);

	boolean batchSave(List<CycInfoContacts> bean);

	boolean batchUpdate(List<CycInfoContacts> bean);

	boolean batchDelete(List<CycInfoContacts> bean);

}