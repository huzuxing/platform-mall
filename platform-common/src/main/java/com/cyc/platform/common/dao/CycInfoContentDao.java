package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycInfoContacts;
import com.cyc.platform.common.entity.CycInfoContent;
import com.cyc.platform.common.sqlprovider.CycInfoContentProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import javax.persistence.ManyToOne;
import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycInfoContentDao")
public interface CycInfoContentDao {

	List<CycInfoContent> findList(CycInfoContent bean);

	@SelectProvider(type = CycInfoContentProvider.class, method = "findPage")
	@Results({
		@Result(property = "pictures", column = "id",javaType = List.class,
		many = @Many(select = "com.cyc.platform.common.dao.CycInfoPictureDao.findList")),
			@Result(property = "contact", column = "contact_id",javaType = CycInfoContacts.class,
					one = @One(select = "com.cyc.platform.common.dao.CycInfoContactsDao.findById",fetchType = FetchType.EAGER))
	})
	List<CycInfoContent> findPage(CycInfoContent bean, Integer page, Integer row);

	@InsertProvider(type = CycInfoContentProvider.class,method = "save")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int save(CycInfoContent bean);

	int update(CycInfoContent bean);

	@Select("select * from cyc_info_content where id=#{id}")
	@Results({
			@Result(property = "pictures", column = "id",javaType = List.class,
					many = @Many(select = "com.cyc.platform.common.dao.CycInfoPictureDao.findList")),
			@Result(property = "contact", column = "contact_id",
					one = @One(select = "com.cyc.platform.common.dao.CycInfoContactsDao.findById",fetchType = FetchType.EAGER))
	})
	CycInfoContent findById(CycInfoContent bean);

	CycInfoContent delete(CycInfoContent bean);

	boolean batchSave(List<CycInfoContent> bean);

	boolean batchUpdate(List<CycInfoContent> bean);

	boolean batchDelete(List<CycInfoContent> bean);

}