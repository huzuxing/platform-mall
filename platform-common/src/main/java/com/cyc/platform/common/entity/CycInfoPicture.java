package com.cyc.platform.common.entity;


import com.google.gson.annotations.Expose;

/**
 * Auto Created through python on 2018-09-13, author:111
 **/

public class CycInfoPicture{

	@Expose()
	private Integer id;

	/**	信息ID**/
	@Expose()
	private Integer infoId;

	/**	排序**/
	private Integer sort;

	/**	图片地址**/
	@Expose()
	private String url;

	public CycInfoPicture() {}

	public CycInfoPicture(Integer id,Integer infoId,Integer sort,String url) {
		this.id = id;
		this.infoId = infoId;
		this.sort = sort;
		this.url = url;
	}
	public void setId(Integer id) {
		 this.id = id;
	}
	public Integer getId() {
		 return this.id;
	}
	public void setInfoId(Integer infoId) {
		 this.infoId = infoId;
	}
	public Integer getInfoId() {
		 return this.infoId;
	}
	public void setSort(Integer sort) {
		 this.sort = sort;
	}
	public Integer getSort() {
		 return this.sort;
	}
	public void setUrl(String url) {
		 this.url = url;
	}
	public String getUrl() {
		 return this.url;
	}
}