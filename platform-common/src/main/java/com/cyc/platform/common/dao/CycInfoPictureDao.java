package com.cyc.platform.common.dao;


import com.cyc.platform.common.entity.CycInfoPicture;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Auto Created through python on 2018-09-13, author:111 
 **/
@Repository("cycInfoPictureDao")
public interface CycInfoPictureDao {

	@Select("select url from cyc_info_picture where info_id=#{infoId}")
	List<CycInfoPicture> findList(CycInfoPicture bean);

	List<CycInfoPicture> findPage(CycInfoPicture bean, Integer page, Integer row);

	CycInfoPicture save(CycInfoPicture bean);

	CycInfoPicture update(CycInfoPicture bean);

	CycInfoPicture findById(CycInfoPicture bean);

	CycInfoPicture delete(CycInfoPicture bean);

	boolean batchSave(List<CycInfoPicture> bean);

	boolean batchUpdate(List<CycInfoPicture> bean);

	boolean batchDelete(List<CycInfoPicture> bean);

}