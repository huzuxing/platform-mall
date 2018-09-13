package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycInfoStick;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/

public interface CycInfoStickDao {

	List<CycInfoStick> findList(CycInfoStick bean);

	List<CycInfoStick> findPage(CycInfoStick bean, Integer page, Integer row);

	@Insert("insert into cyc_info_stick(name, sort, fee, time_create) values(#{name}, #{sort}, #{fee}, #{timeCreate})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int save(CycInfoStick bean);

	int update(CycInfoStick bean);

	@Select("select * from cyc_info_stick where id=#{id}")
	CycInfoStick findById(CycInfoStick bean);

	CycInfoStick delete(CycInfoStick bean);

	boolean batchSave(List<CycInfoStick> bean);

	boolean batchUpdate(List<CycInfoStick> bean);

	boolean batchDelete(List<CycInfoStick> bean);

}